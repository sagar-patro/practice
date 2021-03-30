package com.practice.sp.ds;

public class Sorting {
	private static String print(int[] e) {
		if(e == null) return "[]";

		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for (int i : e) {
			sb.append(i).append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
	private static void swap(int[]a, int toBeReplaced, int replaceWith) {
		int temp = a[toBeReplaced];
		a[toBeReplaced] = a[replaceWith];
		a[replaceWith] = temp;
	}

	public static int[] bubbleSort(int[] nums) {
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

	/**
	 * 1. Find/Select(pun intended) the shortest element in the list
	 * 2. Swap the left most element with the shortest one
	 * 3. Left most element is sorted
	 * 4. Move 1 step towards right
	 * Repeat step 1-4 till all elements are traversed
	 */
	public static int[] selectionSort(int[] nums) {


		int min;
		for (int i = 0; i < nums.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[min]) {
					min = j;
				}
			}
			if(min != i) swap(nums, i, min);
		}
		return nums;
	}


	public static int[] insertionSort(int[] nums) {
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

	public static void main(String args[]) {
		int[] nums = {4, 3, 1, 6, 2, 8, 9, 2, 1, 7, 12, 10, 5};

		System.out.println("bubbleSort: " + print(bubbleSort(nums)));
		System.out.println("selectionSort: " + print(selectionSort(nums)));
		System.out.println("insertionSort: " + print(insertionSort(nums)));
	}


}