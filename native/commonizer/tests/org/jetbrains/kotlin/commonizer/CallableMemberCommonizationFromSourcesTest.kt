/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.commonizer

import kotlin.contracts.ExperimentalContracts

@ExperimentalContracts
class CallableMemberCommonizationFromSourcesTest : AbstractCommonizationFromSourcesTest() {

    fun testVisibility() = doTestSuccessfulCommonization()

    fun testReturnTypes() = doTestSuccessfulCommonization()

    fun testExtensionReceivers() = doTestSuccessfulCommonization()

    fun testOpenCallableMemberInInterface() = doTestSuccessfulCommonization()
}
