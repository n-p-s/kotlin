import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.pill.PillExtension

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

publish()

standardPublicJars()

dependencies {
    implementation(kotlinStdlib())
    implementation(project(":native:kotlin-native-utils"))

    compileOnly(gradleApi())
    compileOnly("com.android.tools.build:gradle:3.4.0")
    compileOnly(project(":kotlin-project-model"))
}

pill {
    variant = PillExtension.Variant.FULL
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.languageVersion = "1.3"
        kotlinOptions.apiVersion = "1.3"
        kotlinOptions.freeCompilerArgs += listOf(
            "-Xskip-prerelease-check",
            "-Xskip-runtime-version-check",
            "-Xsuppress-version-warnings"
        )
    }

    named<Jar>("jar") {
        callGroovy("manifestAttributes", manifest, project)
    }
}
