package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val correctPositions = secret.zip(guess).count() { it.first == it.second }

    var secretChars = secret.toCharArray()
    val guessChars  = guess.toCharArray()
    var commonCharacterCount = 0
    for (gc: Char in guessChars) {
        if (secretChars.contains(gc)) {
            commonCharacterCount++

            val charIx = secretChars.indexOf(gc)
            val smallerSecret = secretChars.copyOfRange(0, charIx) + secretChars.copyOfRange(charIx + 1, secretChars.size)
            secretChars = smallerSecret
        }
    }
    val wrongPositions = commonCharacterCount - correctPositions
/*
    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count { it.equals(ch) }, guess.count { it.equals(ch) })
    }
    val wrongPositions = commonLetters - correctPositions
*/



    return Evaluation(correctPositions, wrongPositions)
}
