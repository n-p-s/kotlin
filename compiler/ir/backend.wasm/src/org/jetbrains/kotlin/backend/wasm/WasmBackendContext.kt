/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.wasm

import org.jetbrains.kotlin.backend.common.CommonBackendContext
import org.jetbrains.kotlin.backend.common.ir.Ir
import org.jetbrains.kotlin.backend.common.ir.Symbols
import org.jetbrains.kotlin.backend.js.JsDeclarationFactory
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor
import org.jetbrains.kotlin.descriptors.impl.EmptyPackageFragmentDescriptor
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.UNDEFINED_OFFSET
import org.jetbrains.kotlin.ir.backend.js.JsSharedVariablesManager
import org.jetbrains.kotlin.ir.builders.declarations.addFunction
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.declarations.impl.IrExternalPackageFragmentImpl
import org.jetbrains.kotlin.ir.descriptors.IrBuiltIns
import org.jetbrains.kotlin.ir.expressions.impl.IrBlockBodyImpl
import org.jetbrains.kotlin.ir.symbols.IrClassSymbol
import org.jetbrains.kotlin.ir.symbols.IrExternalPackageFragmentSymbol
import org.jetbrains.kotlin.ir.symbols.impl.IrExternalPackageFragmentSymbolImpl
import org.jetbrains.kotlin.ir.util.SymbolTable
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name

class WasmBackendContext(
    val module: ModuleDescriptor,
    override val irBuiltIns: IrBuiltIns,
    symbolTable: SymbolTable,
    irModuleFragment: IrModuleFragment,
    val additionalExportedDeclarations: Set<FqName>,
    override val configuration: CompilerConfiguration
) : CommonBackendContext {
    override val builtIns = module.builtIns
    override var inVerbosePhase: Boolean = false

    // Place to store declarations excluded from code generation
    val excludedDeclarations: IrPackageFragment by lazy {
        IrExternalPackageFragmentImpl(
            DescriptorlessExternalPackageFragmentSymbol(),
            FqName("kotlin")
        )
    }

    override val declarationFactory = JsDeclarationFactory()

    val objectToGetInstanceFunction = mutableMapOf<IrClassSymbol, IrSimpleFunction>()
    override val internalPackageFqn = FqName("kotlin.wasm")

    val internalPackageFragment = IrExternalPackageFragmentImpl(
        IrExternalPackageFragmentSymbolImpl(
            EmptyPackageFragmentDescriptor(builtIns.builtInsModule, FqName("kotlin.wasm.internal"))
        )
    )

    val startFunction = internalPackageFragment.addFunction {
        name = Name.identifier("startFunction")
        returnType = irBuiltIns.unitType
    }.apply {
        body = IrBlockBodyImpl(UNDEFINED_OFFSET, UNDEFINED_OFFSET)
    }

    override val sharedVariablesManager = JsSharedVariablesManager(irBuiltIns, internalPackageFragment)

    val wasmSymbols: WasmSymbols = WasmSymbols(this@WasmBackendContext, symbolTable)
    override val ir = object : Ir<WasmBackendContext>(this, irModuleFragment) {
        override val symbols: Symbols<WasmBackendContext> = wasmSymbols
        override fun shouldGenerateHandlerParameterForDefaultBodyFun() = true
    }

    override fun log(message: () -> String) {
        /*TODO*/
        if (inVerbosePhase) print(message())
    }

    override fun report(element: IrElement?, irFile: IrFile?, message: String, isError: Boolean) {
        /*TODO*/
        print(message)
    }
}

class DescriptorlessExternalPackageFragmentSymbol : IrExternalPackageFragmentSymbol {
    override val descriptor: PackageFragmentDescriptor
        get() = error("Operation is unsupported")

    private var _owner: IrExternalPackageFragment? = null
    override val owner get() = _owner!!

    override val isBound get() = _owner != null

    override fun bind(owner: IrExternalPackageFragment) {
        _owner = owner
    }
}



