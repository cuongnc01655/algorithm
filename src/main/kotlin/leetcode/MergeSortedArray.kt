package leetcode

import kotlin.test.assertEquals

/**
In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.
Each order is represented by an "order id" (an integer).

We have our lists of orders sorted numerically already, in arrays. Write a method to merge our arrays of orders into one sorted array.

For example:

int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
// prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
        */

object MergeSortedArray {
    fun solution(arr1: IntArray, arr2: IntArray): IntArray {
        var index1 = 0
        var index2 = 0
        val size1 = arr1.size
        val size2 = arr2.size
        val result = IntArray(arr1.size + arr2.size)
        while (index1 + index2 < result.size) {
            when {
                index1 == size1 -> {
                    result[index1 + index2] = arr2[index2]
                    index2++
                }
                index2 == size2 -> {
                    result[index1 + index2] = arr1[index1]
                    index1++
                }
                arr2[index2] < arr1[index1] -> {
                    result[index1 + index2] = arr2[index2]
                    index2++
                }
                arr1[index1] < arr2[index2] -> {
                    result[index1 + index2] = arr1[index1]
                    index1++
                }
            }
        }
        return result
    }

    fun test() {
        testWithSampleInput()
        testSizeDiffArray()
        testEmptyArray()
    }

    private fun testSizeDiffArray() {
        val arr1 = intArrayOf(1,2,3,4,6,7,8,9)
        val arr2 = intArrayOf(0,5)
        solution(arr1, arr2).forEachIndexed{index, value-> assertEquals(index, value)}
    }

    private fun testWithSampleInput() {
        val expected = intArrayOf(1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19)
        solution(intArrayOf(3, 4, 6, 10, 11, 15), intArrayOf(1, 5, 8, 12, 14, 19)).forEachIndexed{index, value ->
            assertEquals(expected[index], value)
        }
    }

    private fun testEmptyArray() {
        assertEquals(0, solution(intArrayOf(), intArrayOf()).size)
    }
}

fun main() {
    MergeSortedArray.test()
}
