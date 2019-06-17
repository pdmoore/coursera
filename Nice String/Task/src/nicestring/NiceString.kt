package nicestring

fun String.isNice(): Boolean {

    val noBadSubstring = !contains("ba") && !contains("be") && !contains("bu")

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val pairs = this.toList().zipWithNext();

    val hasPair = checkForPair(pairs)

    if (!noBadSubstring) {
        return (hasThreeVowels) && (hasPair);
    }

    if (noBadSubstring) {
        if ((hasThreeVowels) || hasPair) return true
    }


    return false;
}

fun checkForPair(pairs: List<Pair<Char, Char>>): Boolean {
    pairs.forEach { if (it.first == it.second) return true }

    return false
}
