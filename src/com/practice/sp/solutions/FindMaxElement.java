package com.practice.sp.solutions;

public class FindMaxElement {
	public static void main(String args[]) {
		int[] nums = new int[] {1,1,1,4,4,4,4,5};
		System.out.println(findMax(nums));
	}

	private static int findMax(int[] nums) {
		int maxsum = 1;
		int result = 0;

		int currSum = 1;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i - 1] == nums[i]) {
				currSum++;
			} else {
				currSum = 1;
			}

			if(currSum > maxsum) {
				maxsum = currSum;
				result = nums[i];
			}
		}

		return result;
	}
}
