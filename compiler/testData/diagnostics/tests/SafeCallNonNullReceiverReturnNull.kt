// !WITH_NEW_INFERENCE
fun Int.gg() = null

fun ff() {
    val a: Int = 1
    val b: Int = <!TYPE_MISMATCH!>a<!UNNECESSARY_SAFE_CALL!>?.<!>gg()<!>
}
