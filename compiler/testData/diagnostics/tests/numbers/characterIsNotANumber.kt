// !WITH_NEW_INFERENCE
fun foo(n: Number) = n

fun test() {
    foo(<!CONSTANT_EXPECTED_TYPE_MISMATCH!>'a'<!>)

    val c = 'c'
    foo(<!TYPE_MISMATCH!>c<!>)

    val d: Char? = 'd'
    foo(<!TYPE_MISMATCH{NI}!><!TYPE_MISMATCH{OI}!>d<!>!!<!>)
}
