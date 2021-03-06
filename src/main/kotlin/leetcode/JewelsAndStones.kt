package leetcode

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0

Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

 */
object JewelsAndStones {
    fun numJewelsInStones(J: String, S: String): Int {
        val jewels = J.toHashSet()
        return S.filter { jewels.contains(it) }.length
    }

    fun numJewelsInStonesWithoutHashSet(J: String, S: String): Int {
        val jewels = IntArray(58)

        J.forEach { jewels[it - 'A'] = 1 }
        return S.filter { jewels[it - 'A'] > 0 }.length
    }
}

class JewelsAndStonesTest
fun main() {
    println(JewelsAndStones.numJewelsInStonesWithoutHashSet("z", "ZZ"))
}