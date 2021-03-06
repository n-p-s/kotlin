fun <T> f(): T? = "OK" as? T

fun g(): Nothing = throw RuntimeException("fail")

fun <T : Any> h(): T = run<T?> { f() } ?: run { g() }

fun box(): String = h<String>()
