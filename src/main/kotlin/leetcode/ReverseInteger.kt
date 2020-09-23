package leetcode

import java.lang.NumberFormatException
import kotlin.math.abs


object ReverseInteger {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE) return 0
        return if (x < 0) {
            -1 * reversePositive( -1 * x)
        } else {
            reversePositive(x)
        }
    }
    private fun reversePositive(x: Int): Int {
        val str = x.toString().reversed()
        return try {
            str.toInt()
        } catch (ex: NumberFormatException) {
            0
        }
    }
}

fun main() {
    println(ReverseInteger.reverse(123))
}