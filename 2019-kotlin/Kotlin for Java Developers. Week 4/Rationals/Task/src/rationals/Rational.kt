package rationals

import java.math.BigInteger;


data class Rational(val numerator: BigInteger, val denominator: BigInteger) {
    override fun toString(): String {

        val gcd = numerator.gcd(denominator);
        val normalizedNumerator   = numerator.div(gcd)
        val normalizedDenominator = denominator.div(gcd)

        if (normalizedDenominator == 1.toBigInteger()) {
            return "$normalizedNumerator"
        }

        return "$normalizedNumerator/$normalizedDenominator"
    }

}

infix fun Any.divBy(denominator: Int): Rational {
    return Rational(1.toBigInteger(), 2.toBigInteger())
}

fun String.toRational(): Rational {
    val slash = this.indexOf('/')
    val numerator = this.substring(0, slash).toBigInteger()
    val denominator = this.substring(slash + 1).toBigInteger()

    return Rational(numerator, denominator)
}

operator fun Rational.plus(b: Rational): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Rational.minus(b: Rational): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Rational.times(b: Rational): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Rational.div(b: Rational): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Rational.unaryMinus(): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Rational.compareTo(other: Rational): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Rational.rangeTo(rangeEnd: Rational): Any {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

operator fun Any.contains(other: Rational): Boolean {
    return false;
}

infix fun BigInteger.divBy(denominator: BigInteger): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

infix fun Long.divBy(denominator: Long): Rational {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}






fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}







