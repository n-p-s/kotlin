// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_ANONYMOUS_PARAMETER -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE
// NI_EXPECTED_FILE

class GenericController<T> {
    suspend fun yield(t: T) {}
}

fun <S> generate(g: suspend GenericController<S>.(S) -> Unit): S = TODO()

val test1 = generate {
    yield(<!ARGUMENT_TYPE_MISMATCH!>4<!>)
}

val test2 = generate<Int> {
    yield(4)
}

val test3 = generate { bar: Int ->
    yield(4)
}
