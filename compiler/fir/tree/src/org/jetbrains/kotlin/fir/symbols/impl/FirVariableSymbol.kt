/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.symbols.impl

import org.jetbrains.kotlin.fir.declarations.FirErrorProperty
import org.jetbrains.kotlin.fir.declarations.FirField
import org.jetbrains.kotlin.fir.declarations.FirProperty
import org.jetbrains.kotlin.fir.declarations.FirVariable
import org.jetbrains.kotlin.fir.diagnostics.ConeDiagnostic
import org.jetbrains.kotlin.fir.expressions.FirExpression
import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.name.LocalCallableIdConstructor
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name

open class FirVariableSymbol<D : FirVariable<D>>(override val callableId: CallableId) : FirCallableSymbol<D>() {
    constructor(name: Name) : this(@OptIn(LocalCallableIdConstructor::class) CallableId(name))  // TODO?
}

open class FirPropertySymbol(
    callableId: CallableId,
) : FirVariableSymbol<FirProperty>(callableId) {
    // TODO: should we use this constructor for local variables?
    constructor(name: Name) : this(@OptIn(LocalCallableIdConstructor::class) CallableId(name))
}

class FirIntersectionOverridePropertySymbol(
    callableId: CallableId,
    override val intersections: Collection<FirCallableSymbol<*>>
) : FirPropertySymbol(callableId), FirIntersectionCallableSymbol

class FirBackingFieldSymbol(callableId: CallableId) : FirVariableSymbol<FirProperty>(callableId)

class FirDelegateFieldSymbol<D : FirVariable<D>>(callableId: CallableId) : FirVariableSymbol<D>(callableId) {
    val delegate: FirExpression
        get() = fir.delegate!!
}

class FirFieldSymbol(callableId: CallableId) : FirVariableSymbol<FirField>(callableId)

class FirErrorPropertySymbol(
    val diagnostic: ConeDiagnostic
) : FirVariableSymbol<FirErrorProperty>(CallableId(FqName.ROOT, null, NAME)) {
    companion object {
        val NAME: Name = Name.special("<error property>")
    }
}
