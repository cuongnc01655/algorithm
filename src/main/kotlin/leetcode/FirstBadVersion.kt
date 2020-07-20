package leetcode

import java.lang.Exception

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.

 */

abstract class VersionControl {
    var badVersion: Int = 0

    fun isBadVersion(version: Int): Boolean {
        return version >= badVersion
    }

    abstract fun firstBadVersion(n: Int): Int
}

class FirstBadVersion: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var left = 1
        var right = n
        while(left < right) {
            val mid = left + (right - left) / 2
            if(isBadVersion(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left

    }
}

class TestFirstBadVersion
    fun main() {
        val versionControl = FirstBadVersion()
//        Test for edges, odd, even
        for (n in listOf(1, 9, 10, Int.MAX_VALUE)) {
            for (i in listOf(1, n, 1 + (n - 1) / 2)) {
                versionControl.badVersion = 1
                if(versionControl.firstBadVersion(n) != versionControl.badVersion) {
                    throw Exception("Incorrect result, n = $n, i = $i, result = ${versionControl.firstBadVersion(n)}")
                }
            }
        }
    }

