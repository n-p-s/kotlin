fun foo(x: Any?, p: Int) {
    if (p > 0) {
        val x = f()
        print(x!!)
    }
    else {
        val x = g()
        print(x!!)
    }

    <caret>x.hashCode()
}

fun f(): Any? = null
fun g(): Any? = null