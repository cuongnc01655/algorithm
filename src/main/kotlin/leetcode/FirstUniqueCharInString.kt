package leetcode

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.


Note: You may assume the string contain only lowercase English letters.
 */
class FirstUniqueCharInString  {
    fun firstUniqChar(s: String): Int {
        val charMap = HashMap<Char, Int>()
        var minIndex = -1

        for (c in s) {
            charMap[c] = charMap.getOrDefault(c, 0) + 1
        }
        for (i in s.indices) {
            val c = s[i]
            if (charMap[c] == 1) return i
        }
        return -1
    }
}