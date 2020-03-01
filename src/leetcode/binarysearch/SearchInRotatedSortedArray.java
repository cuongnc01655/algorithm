package leetcode.binarysearch;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search( arr,0));
        System.out.println(search( arr,2));
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int minIndex = findMinIndex(nums);
        if (nums[minIndex] == target) return minIndex;
        int low = nums[0] >= target ? minIndex : 0;
        int high = nums[0] >= target ? nums.length - 1 : minIndex - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private static int findMinIndex(int[] nums) {
        int low= 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
