class A

interface B : <!INTERFACE_WITH_SUPERCLASS, SUPERTYPE_INITIALIZED_IN_INTERFACE!>A<!>()

interface C
class D

interface E : <!INTERFACE_WITH_SUPERCLASS, SUPERTYPE_INITIALIZED_IN_INTERFACE!>A<!>(), C, <!SUPERTYPE_INITIALIZED_IN_INTERFACE!>D<!>()
