package com.practice.dell.com.practice.dell.solutions;

public class Sorting {
	public static void main(String args[]) {
		int[] nums = {4, 3, 1, 6, 2, 8, 9, 2, 1, 7, 12, 10, 5};
		int[] result = insertionSort(nums);

		System.out.print("[");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
		System.out.print("]");
	}

	public static int[] bubbleSort(int[] nums) { //[1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, ]
		for (int i = nums.length - 1; i >= 0 ; i--) {
			for(int j = 0; j < i; j++) {
				if(nums[j] > nums [j+1]) {
						int temp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = temp;
				}
			}
		}
		return nums;
	}

	public static int[] insertionSort(int[] nums) { //[1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, ]
		for (int i = 0; i < nums.length-1 ; i++) {

			int temp = nums[i+1];
			int j = i + 1;
			while(j > 0 && temp < nums[j-1]) {
				nums[j] = nums[j-1];
				j--;
			}
			nums[j] = temp;
		}

		return nums;
	}
}