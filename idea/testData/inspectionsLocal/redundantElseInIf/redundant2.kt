fun foo(): Int = 1
fun bar(): Int = 2

fun test(x: Boolean) {
    if (x) {
        return
    } else<caret> {
        foo()
        bar()
    }
}