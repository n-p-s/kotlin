// "Make 'IterablePipeline' 'abstract'" "true"
// ERROR: One type argument expected for interface Pipeline<TPipeline>

// Actually this test is about getting rid of assertion happenning while creating quick fixes
// See KT-10409
interface Pipeline<TPipeline> {
    fun pipe(block: Pipeline<TPipeline, String>)
    fun completelyAbstract()
}

<caret>class IterablePipeline<T> : Pipeline<T> {
    override fun pipe(block: Pipeline<T>) {
    }
}

/* IGNORE_FIR */