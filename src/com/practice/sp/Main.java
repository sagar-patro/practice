package com.practice.sp;

public class Main {

	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length + nums2.length;
		int[] median;
		if(n % 2 != 0) {
			median = new int[1];
			median[0] = n/2;
		} else {
			median = new int[2];
			median[0] = (n - 1)/2;
			median[1] = (n + 1)/2;
		}

		if(median.length == 1) {
			if(median[0] < nums1.length) return nums1[median[0]];
			else {
				int index = median[0] - nums1.length;
				return nums2[index];
			}
		}
		return -1;
	}
}


