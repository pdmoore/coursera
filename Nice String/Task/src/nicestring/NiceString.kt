package nicestring

fun String.isNice(): Boolean {

    val hasThreeVowels = count { it in "aeiou" } >= 3

    val pairs = this.toList().zipWithNext();

    val hasPair = checkForPair(pairs)
    val noBvowels = checkForBvowel(pairs)

    if (!noBvowels) {
        return (hasThreeVowels) && (hasPair);
    }

    if (noBvowels) {
        if ((hasThreeVowels) || hasPair) return true
    }


    return false;
}

fun checkForBvowel(pairs: List<Pair<Char, Char>>): Boolean {
    pairs.forEach { if ((it.first == 'b') &&
            (it.second == 'u' || it.second == 'a' || it.second == 'e')) return false
    }

    return true
}

fun checkForPair(pairs: List<Pair<Char, Char>>): Boolean {
    pairs.forEach { if (it.first == it.second) return true }


    return false
}
