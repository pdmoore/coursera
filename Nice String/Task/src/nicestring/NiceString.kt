package nicestring

fun String.isNice(): Boolean {

    val noBadSubstring = setOf("ba", "be", "bu").none { this.contains(it) }

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val hasDouble = zipWithNext().any { it.first == it.second }


    if (!noBadSubstring) {
        return (hasThreeVowels) && (hasDouble);
    }

    if (noBadSubstring) {
        if ((hasThreeVowels) || hasDouble) return true
    }


    return false;
}
