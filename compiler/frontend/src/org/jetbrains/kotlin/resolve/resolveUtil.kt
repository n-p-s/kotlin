/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.resolve

import org.jetbrains.kotlin.descriptors.CallableMemberDescriptor
import org.jetbrains.kotlin.descriptors.PropertyDescriptor
import org.jetbrains.kotlin.resolve.source.KotlinSourceElement

fun PropertyDescriptor.hasBackingField(bindingContext: BindingContext?): Boolean = when {
    kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE -> overriddenDescriptors.any { it.hasBackingField(bindingContext) }
    extensionReceiverParameter != null -> false
    source is KotlinSourceElement && bindingContext != null -> bindingContext.get(BindingContext.BACKING_FIELD_REQUIRED, this) ?: false
    compileTimeInitializer != null -> true
//    backingField != null -> true // TODO: in case of DeserializedPropetyDescriptor this function returns incorrect result for FO field
    getter != null -> false
    else -> true
}
