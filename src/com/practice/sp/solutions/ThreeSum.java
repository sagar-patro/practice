package com.practice.sp.solutions;

import java.util.Arrays;
import java.util.HashMap;

public class ThreeSum {
  
	public static void main(String[] args) {
		int[] n = {1, 2, 3, 0, 0, 6, 0};

		threeSum(n, 6);
	}
  
	private static int[] find2Sum(int[] nums, int sum, int start) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = start; i < nums.length; i++) {
//			if(i == indexToAvoid) continue;

			int complement = sum - nums[i];
			if(map.containsKey(complement)) {

				return new int[] {nums[map.get(complement)], nums[i]};
			}

			map.put(nums[i], i);
		}
		return new int[0];
	}

	private static void threeSum(int[] n, int sum) {

		for (int i = 0; i < n.length - 2; i++) {
			int twoSum = sum - n[i];

			int[] temp = find2Sum(n, twoSum, i + 1);
			if(temp.length > 0) {
				System.out.print(n[i] + ", ");

				Arrays.stream(temp).boxed()
						.map(String::valueOf)
						.reduce((a, b) -> a + ", " + b)
						.ifPresent(System.out::println);
			}
		}

	}

}
