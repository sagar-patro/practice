package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TwoSum {
	private static int[] find2Sum(int[] nums, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();


		for(int i = 0; i < nums.length; i++) {
			int complement = sum - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {nums[map.get(complement)], nums[i]};
			}

			map.put(nums[i], i);
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[] n = {-1, 1, -2, 2, 4, 0, 0, 0};
		find2Sum(n, 0);

		Arrays.stream(find2Sum(n, 3)).boxed()
				.map(String::valueOf)
				.reduce((a, b) -> a + ", " + b)
				.ifPresent(System.out::println);
	}
}
