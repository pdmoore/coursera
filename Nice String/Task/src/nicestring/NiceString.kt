package nicestring

fun String.isNice(): Boolean {

    val noBadSubstring = setOf("ba", "be", "bu").none { this.contains(it) }

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val hasDouble = zipWithNext().any { it.first == it.second }


    return listOf(noBadSubstring, hasThreeVowels, hasDouble).count { it } >= 2


    return false
}
