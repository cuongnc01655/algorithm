package leetcode

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true

Constraints:

You may assume that both strings contain only lowercase letters.
 */
class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val chars = IntArray(26)
        magazine.forEach { chars[it - 'a'] += 1 }
        for (i in ransomNote.indices) {
            val c = ransomNote[i] - 'a'
            chars[c] -= 1
            if (chars[c] < 0) return false
        }
        return true
    }
}