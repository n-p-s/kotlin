// "Add non-null asserted (!!) call" "true"

operator fun Int.get(row: Int, column: Int) = if (row == column) this else null
fun foo(arg: Int) = arg[42, 13]<caret>.hashCode()
/* IGNORE_FIR */