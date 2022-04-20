package com.practice.sp.solutions;

/**
 * Leetcode# 153
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int result = nums[0];
        while(l <= r) {
            if(nums[l] <= nums[r]) return Math.min(result, nums[l]);

            int mid = (l + r) / 2;
            result = Math.min(result, nums[mid]);

            //When mid is greater than left element, it is obvious that left side is sorted
            //Since left side is sorted, it is imperious that we search right cause when rotation happens-
            //-smaller elements move to right. e.g. below
            //[1, 2, 3, 4, 5] rotated will be [3, 4, 5, 1, 2]: Here the 5 > 3 so right side is the one to search for
            if(nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 11, 12, 13, 1};
        System.out.println(findMin(nums));
    }
}
