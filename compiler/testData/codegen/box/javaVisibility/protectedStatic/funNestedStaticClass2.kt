// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: J.java

public class J {
    public static class A {
        public static class B {
            protected static String protectedFun() {
                return "OK";
            }
        }
    }
}

// MODULE: main(lib)
// FILE: 1.kt

class Derived : J.A.B() {
    fun test(): String {
        return J.A.B.protectedFun()!!
    }
}

fun box(): String {
    return Derived().test()
}
