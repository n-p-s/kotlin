/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.commonizer.cli

import org.jetbrains.kotlin.commonizer.*
import org.jetbrains.kotlin.commonizer.konan.*
import org.jetbrains.kotlin.commonizer.repository.*
import org.jetbrains.kotlin.commonizer.stats.FileStatsOutput
import org.jetbrains.kotlin.commonizer.stats.StatsCollector
import org.jetbrains.kotlin.commonizer.stats.StatsType
import org.jetbrains.kotlin.commonizer.utils.ProgressLogger
import org.jetbrains.kotlin.konan.library.KONAN_DISTRIBUTION_KLIB_DIR
import org.jetbrains.kotlin.konan.library.KONAN_DISTRIBUTION_PLATFORM_LIBS_DIR
import org.jetbrains.kotlin.konan.target.KonanTarget
import java.io.File

internal class NativeDistributionListTargets(options: Collection<Option<*>>) : Task(options) {
    override val category get() = Category.INFORMATIONAL

    override fun execute(logPrefix: String) {
        val distributionPath = getMandatory<File, NativeDistributionOptionType>()

        val targets = distributionPath.resolve(KONAN_DISTRIBUTION_KLIB_DIR)
            .resolve(KONAN_DISTRIBUTION_PLATFORM_LIBS_DIR)
            .list()
            ?.sorted()
            ?: emptyList()

        println()
        if (targets.isEmpty())
            println("No hardware targets found inside of the Kotlin/Native distribution \"$distributionPath\".")
        else {
            println("${targets.size} hardware targets found inside of the Kotlin/Native distribution \"$distributionPath\":")
            targets.forEach(::println)
        }
        println()
    }
}

internal class NativeKlibCommonize(options: Collection<Option<*>>) : Task(options) {
    override val category: Category = Category.COMMONIZATION

    override fun execute(logPrefix: String) {
        val distribution = KonanDistribution(getMandatory<File, NativeDistributionOptionType>())
        val destination = getMandatory<File, OutputOptionType>()
        val targetLibraries = getMandatory<List<File>, InputLibrariesOptionType>()
        val dependencyLibraries = getOptional<List<CommonizerDependency>, DependencyLibrariesOptionType>().orEmpty()
        val outputCommonizerTarget = compatGetOutputTarget()
        val statsType = getOptional<StatsType, StatsTypeOptionType> { it == "log-stats" } ?: StatsType.NONE
        val logLevel = getOptional<CommonizerLogLevel, LogLevelOptionType>() ?: CommonizerLogLevel.Quiet


        val konanTargets = outputCommonizerTarget.konanTargets
        val commonizerTargets = konanTargets.map(::CommonizerTarget)

        val logger = ProgressLogger(CliLoggerAdapter(logLevel, 2))
        val libraryLoader = DefaultNativeLibraryLoader(logger)
        val statsCollector = StatsCollector(statsType, commonizerTargets)
        val repository = FilesRepository(targetLibraries.toSet(), libraryLoader)

        val resultsConsumer = buildResultsConsumer {
            this add ModuleSerializer(destination, HierarchicalCommonizerOutputLayout)
            this add CopyUnconsumedModulesAsIsConsumer(
                repository, destination, commonizerTargets.toSet(), NativeDistributionCommonizerOutputLayout
            )
            this add LoggingResultsConsumer(outputCommonizerTarget)
        }

        LibraryCommonizer(
            outputTarget = outputCommonizerTarget,
            repository = repository,
            dependencies = StdlibRepository(distribution, libraryLoader) +
                    CommonizerDependencyRepository(dependencyLibraries.toSet(), libraryLoader),
            resultsConsumer = resultsConsumer,
            statsCollector = statsCollector,
            progressLogger = logger
        ).run()

        statsCollector?.writeTo(FileStatsOutput(destination, statsType.name.lowercase()))
    }
}

internal class NativeDistributionCommonize(options: Collection<Option<*>>) : Task(options) {
    override val category get() = Category.COMMONIZATION

    override fun execute(logPrefix: String) {
        val distribution = KonanDistribution(getMandatory<File, NativeDistributionOptionType>())
        val destination = getMandatory<File, OutputOptionType>()

        val outputTarget = compatGetOutputTarget()
        val outputLayout = if (getOptional<SharedCommonizerTarget, OutputCommonizerTargetOptionType>() != null)
            HierarchicalCommonizerOutputLayout
        else NativeDistributionCommonizerOutputLayout


        val copyStdlib = getOptional<Boolean, BooleanOptionType> { it == "copy-stdlib" } ?: false
        val copyEndorsedLibs = getOptional<Boolean, BooleanOptionType> { it == "copy-endorsed-libs" } ?: false
        val statsType = getOptional<StatsType, StatsTypeOptionType> { it == "log-stats" } ?: StatsType.NONE
        val logLevel = getOptional<CommonizerLogLevel, LogLevelOptionType>() ?: CommonizerLogLevel.Quiet

        val logger = ProgressLogger(CliLoggerAdapter(logLevel, 2))
        val libraryLoader = DefaultNativeLibraryLoader(logger)
        val repository = KonanDistributionRepository(distribution, outputTarget.konanTargets, libraryLoader)
        val statsCollector = StatsCollector(statsType, outputTarget.withAllAncestors().toList())

        val resultsConsumer = buildResultsConsumer {
            this add ModuleSerializer(destination, outputLayout)
            this add CopyUnconsumedModulesAsIsConsumer(repository, destination, outputTarget.allLeaves(), outputLayout)
            if (copyStdlib) this add CopyStdlibResultsConsumer(distribution, destination)
            if (copyEndorsedLibs) this add CopyEndorsedLibrairesResultsConsumer(distribution, destination)
            this add LoggingResultsConsumer(outputTarget)
        }

        val descriptionSuffix = estimateLibrariesCount(repository, outputTarget.allLeaves()).let { " ($it items)" }
        logger.log("${logPrefix}Preparing commonized Kotlin/Native libraries for $outputTarget$descriptionSuffix")

        LibraryCommonizer(
            outputTarget = outputTarget,
            repository = repository,
            dependencies = StdlibRepository(distribution, libraryLoader),
            resultsConsumer = resultsConsumer,
            statsCollector = statsCollector,
            progressLogger = logger
        ).run()

        statsCollector?.writeTo(FileStatsOutput(destination, statsType.name.lowercase()))
    }

    companion object {
        private fun estimateLibrariesCount(repository: Repository, targets: Iterable<LeafCommonizerTarget>): Int {
            return targets.flatMap { repository.getLibraries(it) }.count()
        }
    }
}

private fun Task.compatGetOutputTarget(): SharedCommonizerTarget {
    getOptional<SharedCommonizerTarget, OutputCommonizerTargetOptionType>()?.let { return it }
    val konanTargets = getOptional<List<KonanTarget>, NativeTargetsOptionType>() ?: throw IllegalArgumentException(
        "Missing ${OutputCommonizerTargetOptionType.alias} or deprecated ${NativeTargetsOptionType.alias} option was specified"
    )
    return SharedCommonizerTarget(konanTargets)
}
