package leetcode

import java.lang.Exception

/**
 * Given a positive integer num, output its complement number. The complement strategy is to flip the bits of its binary representation.



Example 1:

Input: num = 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:

Input: num = 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.


Constraints:

The given integer num is guaranteed to fit within the range of a 32-bit signed integer.
num >= 1
You could assume no leading zero bit in the integer’s binary representation.
This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */

object NumberComplement {
    fun findComplement(num: Int): Int {
        if (num > Int.MAX_VALUE / 2) return Int.MAX_VALUE - num
        return ( pow(2, next(num)) - 1 - num).toInt()
    }

    fun pow(a: Int, b: Int): Long {
        var base = 1L
        for (i in 0 until b) {
            base *= a
        }
        return base
    }

    private fun next(num: Int): Int {
        var base = 1
        for (i in 0..num) {
            if (base > num) return i
            if (base == num) return i+ 1
            base *= 2
        }
        throw Exception("should not be here")
    }
}

class NumberComplementTest
    fun main() {
//        println(NumberComplement.findComplement(Int.MAX_VALUE))
        println(NumberComplement.findComplement(Int.MAX_VALUE))
    }