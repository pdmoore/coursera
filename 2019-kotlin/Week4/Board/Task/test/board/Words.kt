package board

import junit.framework.TestCase.assertEquals

// Week 5 - Playground Member extensions
class Words {
    private val list = mutableListOf<String>()

    fun String.record() {
        list.add(this)
    }

    operator fun String.unaryPlus() {
        record()
    }

    override fun toString() = list.toString()
}


fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        "one".record()
        +"two"
    }
    assertEquals("[one, two]", words.toString())
}



