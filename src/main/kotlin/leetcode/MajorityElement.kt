package leetcode

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */
class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val elementCount = HashMap<Int, Int>()
        val halfSize = if(nums.size % 2 == 0) nums.size / 2 else nums.size / 2 + 1
        for (i in nums) {
            elementCount[i] = elementCount.getOrDefault(i, 0) + 1
        }
        elementCount.forEach { (k, v) ->
            if (v >= halfSize) return k
        }
        throw Exception("Should not be here")
    }
}