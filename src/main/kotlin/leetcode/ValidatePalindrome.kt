package leetcode

import leetcode.ValidatePalindrome.firstComeFirstServe
import leetcode.ValidatePalindrome.isPermutationPalindrome
import java.lang.RuntimeException
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object ValidatePalindrome {
    fun validPalindromeInRange(s: String, left: Int, right: Int): Boolean {
        for (i in left..left + (right - left) / 2) {
            if (s[i] != s[right - i + left]) {
                return false
            }
        }
        return true
    }

    fun validPalindrome(s: String): Boolean {
        for (i in 0..s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) {
                val right = s.length - 1 - i
                return validPalindromeInRange(s, i+1, right) || validPalindromeInRange(s, i, right - 1)
            }
        }
        return true
    }


    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in 0..nums.size - 3) {
            if (i == 0 || nums[i] != nums[i-1]) {
                result.addAll(twoSum(nums, i))
            }
        }
        return result
    }

    fun twoSum(nums: IntArray, start: Int): List<List<Int>> {
        val target = -nums[start]
        var low = start + 1
        var high = nums.size - 1
        val result = mutableListOf<List<Int>>()
        while (low < high) {
            when {
                nums[low] + nums[high] == target -> {
                    result.add(listOf(nums[start], nums[low], nums[high]))
                    while (low < high && nums[low] == nums[low + 1]) low++
                    while (low < high && nums[high] == nums[high - 1]) high--
                    low++
                    high--
                }
                nums[low] + nums[high] < target -> low++
                else -> high--
            }
        }
        return result
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) return intArrayOf(map.getValue(target - nums[i]), i)
            map[nums[i]] = i
        }
        return intArrayOf()
    }

    fun checkTwoSum(nums: IntArray, target: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) return true
            map[nums[i]] = i
        }
        return false
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val stack = Stack<TreeNode>()
        val result = mutableListOf<Int>()
        var node = root
        while (node!!.left != null) {
            stack.push(node)
            node = node.left
        }
        while(stack.isNotEmpty()) {
            node = stack.pop()
            result.add(node.`val`)
            if (node.right != null) {
                result.add(node.right!!.`val`)
            }
        }
        return result
    }

    fun topN(s: String, n: Int): List<String> {
        return s.split(" ").groupBy { it }.map { it.key to it.value.size }.sortedBy { it.second }.subList(0, n).map { it.first }
    }

    fun firstComeFirstServe(takeOut: IntArray, dineIn: IntArray, servedOrder: IntArray): Boolean {
        require(takeOut.size + dineIn.size == servedOrder.size)
        var toPointer = 0
        var diPointer = 0
        servedOrder.forEach {
            if (toPointer < takeOut.size && takeOut[toPointer] == it) {
                toPointer++
            } else if (diPointer < dineIn.size && dineIn[diPointer] == it) {
                diPointer++
            } else {
                return false
            }
        }
        return true
    }

    fun isPermutationPalindrome(s: String): Boolean {
        val oddChars = s.toCharArray().groupBy { it }.filter { it.value.size % 2 != 0 }
        return oddChars.size <= 1
    }
}

class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


fun main() {
//    println(ValidatePalindrome.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
//    assertEquals(false, firstComeFirstServe(intArrayOf(1, 3, 5), intArrayOf(2,4,6), intArrayOf(1, 2, 4, 6, 5, 3)))
//    assertEquals(true, firstComeFirstServe(intArrayOf(17, 8, 24), intArrayOf(12, 19, 2), intArrayOf(17, 8, 12, 19, 24, 2)))

    assertTrue (isPermutationPalindrome("civic"))
    assertFalse (isPermutationPalindrome("civil"))
    assertTrue (isPermutationPalindrome("ivicc"))
    assertFalse (isPermutationPalindrome("livci"))
}