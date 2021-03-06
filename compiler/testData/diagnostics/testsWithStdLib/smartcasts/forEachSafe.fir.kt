// !WITH_NEW_INFERENCE
// KT-7186: False "Type mismatch" error

fun indexOfMax(a: IntArray): Int? {
    var maxI: Int? = null
    a.forEachIndexed { i, value ->
        if (maxI == null || value >= a[maxI]) {
            maxI = i
        }
    }
    return maxI
}
