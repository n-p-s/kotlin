/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.declarations.persistent.carriers

import org.jetbrains.kotlin.descriptors.DescriptorVisibility
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.declarations.IrTypeParameter
import org.jetbrains.kotlin.ir.declarations.IrValueParameter
import org.jetbrains.kotlin.ir.expressions.IrBody
import org.jetbrains.kotlin.ir.expressions.IrConstructorCall
import org.jetbrains.kotlin.ir.symbols.IrPropertySymbol
import org.jetbrains.kotlin.ir.symbols.IrSimpleFunctionSymbol
import org.jetbrains.kotlin.ir.symbols.IrSymbol
import org.jetbrains.kotlin.ir.symbols.IrTypeParameterSymbol
import org.jetbrains.kotlin.ir.symbols.IrValueParameterSymbol
import org.jetbrains.kotlin.ir.types.IrType

// Auto-generated by compiler/ir/ir.tree.persistent/generator/src/org/jetbrains/kotlin/ir/persistentIrGenerator/Main.kt. DO NOT EDIT!

internal interface FunctionCarrier : DeclarationCarrier{
    val returnTypeFieldField: IrType
    val dispatchReceiverParameterField: IrValueParameter?
    val dispatchReceiverParameterSymbolField: IrValueParameterSymbol?
    val extensionReceiverParameterField: IrValueParameter?
    val extensionReceiverParameterSymbolField: IrValueParameterSymbol?
    val bodyField: IrBody?
    val visibilityField: DescriptorVisibility
    val typeParametersField: List<IrTypeParameter>
    val typeParametersSymbolField: List<IrTypeParameterSymbol>
    val valueParametersField: List<IrValueParameter>
    val valueParametersSymbolField: List<IrValueParameterSymbol>
    val correspondingPropertySymbolField: IrPropertySymbol?
    val overriddenSymbolsField: List<IrSimpleFunctionSymbol>

    override fun clone(): FunctionCarrier {
        return FunctionCarrierImpl(
            lastModified,
            parentSymbolField,
            originField,
            annotationsField,
            returnTypeFieldField,
            dispatchReceiverParameterSymbolField,
            extensionReceiverParameterSymbolField,
            bodyField,
            visibilityField,
            typeParametersSymbolField,
            valueParametersSymbolField,
            correspondingPropertySymbolField,
            overriddenSymbolsField
        )
    }
}

internal class FunctionCarrierImpl(
    override val lastModified: Int,
    override val parentSymbolField: IrSymbol?,
    override val originField: IrDeclarationOrigin,
    override val annotationsField: List<IrConstructorCall>,
    override val returnTypeFieldField: IrType,
    override val dispatchReceiverParameterSymbolField: IrValueParameterSymbol?,
    override val extensionReceiverParameterSymbolField: IrValueParameterSymbol?,
    override val bodyField: IrBody?,
    override val visibilityField: DescriptorVisibility,
    override val typeParametersSymbolField: List<IrTypeParameterSymbol>,
    override val valueParametersSymbolField: List<IrValueParameterSymbol>,
    override val correspondingPropertySymbolField: IrPropertySymbol?,
    override val overriddenSymbolsField: List<IrSimpleFunctionSymbol>
) : FunctionCarrier {

    override val dispatchReceiverParameterField: IrValueParameter?
        get() = dispatchReceiverParameterSymbolField?.owner

    override val extensionReceiverParameterField: IrValueParameter?
        get() = extensionReceiverParameterSymbolField?.owner

    override val typeParametersField: List<IrTypeParameter> by lazy { typeParametersSymbolField.map { it.owner } }

    override val valueParametersField: List<IrValueParameter> by lazy { valueParametersSymbolField.map { it.owner } }
}
