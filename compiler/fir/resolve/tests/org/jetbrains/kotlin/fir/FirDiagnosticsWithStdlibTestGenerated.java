/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.KotlinTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/fir/resolve/testData/resolve/stdlib")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class FirDiagnosticsWithStdlibTestGenerated extends AbstractFirDiagnosticsWithStdlibTest {
    private void runTest(String testDataFilePath) throws Exception {
        KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
    }

    public void testAllFilesPresentInStdlib() throws Exception {
        KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/fir/resolve/testData/resolve/stdlib"), Pattern.compile("^([^.]+)\\.kt$"), true, "contracts");
    }

    @TestMetadata("anonymousInDelegate.kt")
    public void testAnonymousInDelegate() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/anonymousInDelegate.kt");
    }

    @TestMetadata("arrayFirstOrNull.kt")
    public void testArrayFirstOrNull() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/arrayFirstOrNull.kt");
    }

    @TestMetadata("arrayInLocal.kt")
    public void testArrayInLocal() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/arrayInLocal.kt");
    }

    @TestMetadata("backingField.kt")
    public void testBackingField() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/backingField.kt");
    }

    @TestMetadata("companionLoad.kt")
    public void testCompanionLoad() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/companionLoad.kt");
    }

    @TestMetadata("components.kt")
    public void testComponents() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/components.kt");
    }

    @TestMetadata("concurrent.kt")
    public void testConcurrent() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/concurrent.kt");
    }

    @TestMetadata("exception.kt")
    public void testException() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/exception.kt");
    }

    @TestMetadata("factoryFunctionOverloads.kt")
    public void testFactoryFunctionOverloads() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/factoryFunctionOverloads.kt");
    }

    @TestMetadata("functionX.kt")
    public void testFunctionX() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/functionX.kt");
    }

    @TestMetadata("hashSet.kt")
    public void testHashSet() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/hashSet.kt");
    }

    @TestMetadata("helloWorld.kt")
    public void testHelloWorld() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/helloWorld.kt");
    }

    @TestMetadata("implicitReceiverOrder.kt")
    public void testImplicitReceiverOrder() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/implicitReceiverOrder.kt");
    }

    @TestMetadata("mapList.kt")
    public void testMapList() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/mapList.kt");
    }

    @TestMetadata("multipleImplicitReceivers.kt")
    public void testMultipleImplicitReceivers() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/multipleImplicitReceivers.kt");
    }

    @TestMetadata("problems.kt")
    public void testProblems() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/problems.kt");
    }

    @TestMetadata("recursiveBug.kt")
    public void testRecursiveBug() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/recursiveBug.kt");
    }

    @TestMetadata("reflectionClass.kt")
    public void testReflectionClass() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/reflectionClass.kt");
    }

    @TestMetadata("simpleDelegateProvider.kt")
    public void testSimpleDelegateProvider() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/simpleDelegateProvider.kt");
    }

    @TestMetadata("simpleDelegatedToMap.kt")
    public void testSimpleDelegatedToMap() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/simpleDelegatedToMap.kt");
    }

    @TestMetadata("simpleLazy.kt")
    public void testSimpleLazy() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/simpleLazy.kt");
    }

    @TestMetadata("topLevelResolve.kt")
    public void testTopLevelResolve() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/topLevelResolve.kt");
    }

    @TestMetadata("typeAliasDeserialization.kt")
    public void testTypeAliasDeserialization() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/typeAliasDeserialization.kt");
    }

    @TestMetadata("typeParameterDerived.kt")
    public void testTypeParameterDerived() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/typeParameterDerived.kt");
    }

    @TestMetadata("unaryOperators.kt")
    public void testUnaryOperators() throws Exception {
        runTest("compiler/fir/resolve/testData/resolve/stdlib/unaryOperators.kt");
    }

    @TestMetadata("compiler/fir/resolve/testData/resolve/stdlib/callableReferences")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class CallableReferences extends AbstractFirDiagnosticsWithStdlibTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        public void testAllFilesPresentInCallableReferences() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/fir/resolve/testData/resolve/stdlib/callableReferences"), Pattern.compile("^([^.]+)\\.kt$"), true);
        }

        @TestMetadata("beyoundCalls.kt")
        public void testBeyoundCalls() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/beyoundCalls.kt");
        }

        @TestMetadata("companions.kt")
        public void testCompanions() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/companions.kt");
        }

        @TestMetadata("constructors.kt")
        public void testConstructors() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/constructors.kt");
        }

        @TestMetadata("differentLevels.kt")
        public void testDifferentLevels() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/differentLevels.kt");
        }

        @TestMetadata("extensionReceiverInference.kt")
        public void testExtensionReceiverInference() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/extensionReceiverInference.kt");
        }

        @TestMetadata("implicitTypes.kt")
        public void testImplicitTypes() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/implicitTypes.kt");
        }

        @TestMetadata("inferenceFromCallableReferenceType.kt")
        public void testInferenceFromCallableReferenceType() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/inferenceFromCallableReferenceType.kt");
        }

        @TestMetadata("inferenceFromExpectedType.kt")
        public void testInferenceFromExpectedType() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/inferenceFromExpectedType.kt");
        }

        @TestMetadata("javaStatic.kt")
        public void testJavaStatic() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/javaStatic.kt");
        }

        @TestMetadata("manyCandidatesInference.kt")
        public void testManyCandidatesInference() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/manyCandidatesInference.kt");
        }

        @TestMetadata("manyInnerCandidates.kt")
        public void testManyInnerCandidates() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/manyInnerCandidates.kt");
        }

        @TestMetadata("manyInnerManyOuterCandidates.kt")
        public void testManyInnerManyOuterCandidates() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/manyInnerManyOuterCandidates.kt");
        }

        @TestMetadata("manyInnermanyOuterCandidatesAmbiguity.kt")
        public void testManyInnermanyOuterCandidatesAmbiguity() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/manyInnermanyOuterCandidatesAmbiguity.kt");
        }

        @TestMetadata("manyOuterCandidates.kt")
        public void testManyOuterCandidates() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/manyOuterCandidates.kt");
        }

        @TestMetadata("properties.kt")
        public void testProperties() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/properties.kt");
        }

        @TestMetadata("sam.kt")
        public void testSam() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/sam.kt");
        }

        @TestMetadata("simpleClassReceiver.kt")
        public void testSimpleClassReceiver() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/simpleClassReceiver.kt");
        }

        @TestMetadata("simpleExpressionReceiver.kt")
        public void testSimpleExpressionReceiver() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/simpleExpressionReceiver.kt");
        }

        @TestMetadata("simpleNoReceiver.kt")
        public void testSimpleNoReceiver() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/simpleNoReceiver.kt");
        }

        @TestMetadata("varProperties.kt")
        public void testVarProperties() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/varProperties.kt");
        }

        @TestMetadata("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests")
        @TestDataPath("$PROJECT_ROOT")
        @RunWith(JUnit3RunnerWithInners.class)
        public static class FromBasicDiagnosticTests extends AbstractFirDiagnosticsWithStdlibTest {
            private void runTest(String testDataFilePath) throws Exception {
                KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
            }

            public void testAllFilesPresentInFromBasicDiagnosticTests() throws Exception {
                KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests"), Pattern.compile("^([^.]+)\\.kt$"), true);
            }

            @TestMetadata("ambiguityWhenNoApplicableCallableReferenceCandidate.kt")
            public void testAmbiguityWhenNoApplicableCallableReferenceCandidate() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/ambiguityWhenNoApplicableCallableReferenceCandidate.kt");
            }

            @TestMetadata("applicableCallableReferenceFromDistantScope.kt")
            public void testApplicableCallableReferenceFromDistantScope() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/applicableCallableReferenceFromDistantScope.kt");
            }

            @TestMetadata("chooseCallableReferenceDependingOnInferredReceiver.kt")
            public void testChooseCallableReferenceDependingOnInferredReceiver() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/chooseCallableReferenceDependingOnInferredReceiver.kt");
            }

            @TestMetadata("commonSupertypeFromReturnTypesOfCallableReference.kt")
            public void testCommonSupertypeFromReturnTypesOfCallableReference() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/commonSupertypeFromReturnTypesOfCallableReference.kt");
            }

            @TestMetadata("eagerAndPostponedCallableReferences.kt")
            public void testEagerAndPostponedCallableReferences() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/eagerAndPostponedCallableReferences.kt");
            }

            @TestMetadata("eagerResolveOfSingleCallableReference.kt")
            public void testEagerResolveOfSingleCallableReference() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/eagerResolveOfSingleCallableReference.kt");
            }

            @TestMetadata("moreSpecificAmbiguousExtensions.kt")
            public void testMoreSpecificAmbiguousExtensions() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/moreSpecificAmbiguousExtensions.kt");
            }

            @TestMetadata("multipleOutersAndMultipleCallableReferences.kt")
            public void testMultipleOutersAndMultipleCallableReferences() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/multipleOutersAndMultipleCallableReferences.kt");
            }

            @TestMetadata("noAmbiguityBetweenTopLevelAndMemberProperty.kt")
            public void testNoAmbiguityBetweenTopLevelAndMemberProperty() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/noAmbiguityBetweenTopLevelAndMemberProperty.kt");
            }

            @TestMetadata("overloadsBound.kt")
            public void testOverloadsBound() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/overloadsBound.kt");
            }

            @TestMetadata("postponedResolveOfManyCallableReference.kt")
            public void testPostponedResolveOfManyCallableReference() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/postponedResolveOfManyCallableReference.kt");
            }

            @TestMetadata("resolveCallableReferencesAfterAllSimpleArguments.kt")
            public void testResolveCallableReferencesAfterAllSimpleArguments() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/resolveCallableReferencesAfterAllSimpleArguments.kt");
            }

            @TestMetadata("withGenericFun.kt")
            public void testWithGenericFun() throws Exception {
                runTest("compiler/fir/resolve/testData/resolve/stdlib/callableReferences/fromBasicDiagnosticTests/withGenericFun.kt");
            }
        }
    }

    @TestMetadata("compiler/fir/resolve/testData/resolve/stdlib/j+k")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class J_k extends AbstractFirDiagnosticsWithStdlibTest {
        private void runTest(String testDataFilePath) throws Exception {
            KotlinTestUtils.runTest(this::doTest, this, testDataFilePath);
        }

        public void testAllFilesPresentInJ_k() throws Exception {
            KotlinTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/fir/resolve/testData/resolve/stdlib/j+k"), Pattern.compile("^([^.]+)\\.kt$"), true);
        }

        @TestMetadata("complexFlexibleInference.kt")
        public void testComplexFlexibleInference() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/complexFlexibleInference.kt");
        }

        @TestMetadata("FieldAndGetter.kt")
        public void testFieldAndGetter() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/FieldAndGetter.kt");
        }

        @TestMetadata("FieldSubstitution.kt")
        public void testFieldSubstitution() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/FieldSubstitution.kt");
        }

        @TestMetadata("FunctionTypeInJava.kt")
        public void testFunctionTypeInJava() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/FunctionTypeInJava.kt");
        }

        @TestMetadata("KJKComplexHierarchy.kt")
        public void testKJKComplexHierarchy() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KJKComplexHierarchy.kt");
        }

        @TestMetadata("KJKComplexHierarchyNestedLoop.kt")
        public void testKJKComplexHierarchyNestedLoop() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KJKComplexHierarchyNestedLoop.kt");
        }

        @TestMetadata("KJKComplexHierarchyWithNested.kt")
        public void testKJKComplexHierarchyWithNested() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KJKComplexHierarchyWithNested.kt");
        }

        @TestMetadata("KJKInheritance.kt")
        public void testKJKInheritance() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KJKInheritance.kt");
        }

        @TestMetadata("KJKInheritanceGeneric.kt")
        public void testKJKInheritanceGeneric() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KJKInheritanceGeneric.kt");
        }

        @TestMetadata("KotlinClassParameter.kt")
        public void testKotlinClassParameter() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KotlinClassParameter.kt");
        }

        @TestMetadata("KotlinClassParameterGeneric.kt")
        public void testKotlinClassParameterGeneric() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/KotlinClassParameterGeneric.kt");
        }

        @TestMetadata("LoggerInstance.kt")
        public void testLoggerInstance() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/LoggerInstance.kt");
        }

        @TestMetadata("MyException.kt")
        public void testMyException() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/MyException.kt");
        }

        @TestMetadata("MyIterable.kt")
        public void testMyIterable() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/MyIterable.kt");
        }

        @TestMetadata("MyMap.kt")
        public void testMyMap() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/MyMap.kt");
        }

        @TestMetadata("outerInnerClasses.kt")
        public void testOuterInnerClasses() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/outerInnerClasses.kt");
        }

        @TestMetadata("RawType.kt")
        public void testRawType() throws Exception {
            runTest("compiler/fir/resolve/testData/resolve/stdlib/j+k/RawType.kt");
        }
    }
}
