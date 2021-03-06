// !WITH_NEW_INFERENCE
// !CHECK_TYPE
// !DIAGNOSTICS: -UNUSED_PARAMETER,-UNUSED_VARIABLE

class A<F> {
    class Inv<Q>
    fun <E : Inv<F>> fooInv1(x: E) = x
    fun <E : Inv<F?>> fooInv2(x: E) = x

    class In<in Q>
    fun <E : In<F>> fooIn1(x: E) = x
    fun <E : In<F?>> fooIn2(x: E) = x

    class Out<out Q>
    fun <E : Out<F>> fooOut1(x: E) = x
    fun <E : Out<F?>> fooOut2(x: E) = x

    fun <Z : F, W : Z?> bar() {
        // F
        fooInv1<Inv<F>>(Inv<F>())
        fooInv2<Inv<F>>(<!ARGUMENT_TYPE_MISMATCH!>Inv<F>()<!>)
        fooInv1(Inv<F>())
        fooInv2(<!ARGUMENT_TYPE_MISMATCH!>Inv<F>()<!>)

        fooIn1<In<F?>>(In<F?>())
        fooIn2<In<F?>>(In<F?>())
        fooIn1(In<F?>())
        fooIn2(In<F?>())

        fooOut1<Out<F>>(Out<F>())
        fooOut2<Out<F>>(Out<F>())
        fooOut1(Out<F>())
        fooOut2(Out<F>())

        // Z
        fooInv1<Inv<Z>>(<!ARGUMENT_TYPE_MISMATCH!>Inv<Z>()<!>)
        fooInv2<Inv<Z>>(<!ARGUMENT_TYPE_MISMATCH!>Inv<Z>()<!>)
        fooInv1(<!ARGUMENT_TYPE_MISMATCH!>Inv<Z>()<!>)
        fooInv2(<!ARGUMENT_TYPE_MISMATCH!>Inv<Z>()<!>)

        fooIn1<In<Z?>>(<!ARGUMENT_TYPE_MISMATCH!>In<Z?>()<!>)
        fooIn2<In<Z?>>(<!ARGUMENT_TYPE_MISMATCH!>In<Z?>()<!>)
        fooIn1(<!ARGUMENT_TYPE_MISMATCH!>In<Z?>()<!>)
        fooIn2(<!ARGUMENT_TYPE_MISMATCH!>In<Z?>()<!>)

        fooOut1<Out<Z>>(Out<Z>())
        fooOut2<Out<Z>>(Out<Z>())
        fooOut1(Out<Z>())
        fooOut2(Out<Z>())

        // W
        fooInv1<Inv<W>>(<!ARGUMENT_TYPE_MISMATCH!>Inv<W>()<!>)
        fooInv2<Inv<W>>(<!ARGUMENT_TYPE_MISMATCH!>Inv<W>()<!>)
        fooInv1(<!ARGUMENT_TYPE_MISMATCH!>Inv<W>()<!>)
        fooInv2(<!ARGUMENT_TYPE_MISMATCH!>Inv<W>()<!>)

        fooIn1<In<W?>>(<!ARGUMENT_TYPE_MISMATCH!>In<W?>()<!>)
        fooIn2<In<W?>>(<!ARGUMENT_TYPE_MISMATCH!>In<W?>()<!>)
        fooIn1(<!ARGUMENT_TYPE_MISMATCH!>In<W?>()<!>)
        fooIn2(<!ARGUMENT_TYPE_MISMATCH!>In<W?>()<!>)

        fooOut1<Out<W>>(<!ARGUMENT_TYPE_MISMATCH!>Out<W>()<!>)
        fooOut2<Out<W>>(Out<W>())
        fooOut1(<!ARGUMENT_TYPE_MISMATCH!>Out<W>()<!>)
        fooOut2(Out<W>())
    }
}
