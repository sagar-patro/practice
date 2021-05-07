package com.practice.sp.solutions;

public class Kaden {
	public static void main(String[] args) {
		int[] nums = {-1, -5, 4, 0, -3, 1, 5};
		System.out.println(contiguousSum(nums));
	}

	private static int contiguousSum(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;

		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			if(currSum > maxSum) {
				maxSum = currSum;
			}

			if(currSum < 0) currSum = 0;
		}
		return maxSum;
	}
}
