package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
  
	public static void main(String[] args) {
		int[] n = {1, 2, 3, 0, 0, 6, 0};
		int[] a = {-3, 0, 2, 1, -4, 4, -1};

		//threeSum(a, 0);
		sum3(a);
	}
  
	private static int[] find2Sum(int[] nums, int sum, int start) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = start; i < nums.length; i++) {
//			if(i == indexToAvoid) continue;
			int complement = sum - nums[i];
			if(map.containsKey(complement))
				return new int[] {nums[map.get(complement)], nums[i]};
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

	public static void sum3(int[] a) {
		int n = a.length;
		//List<List<Integer>> ans = new ArrayList<>();
		if (n < 3) return ;
		Arrays.sort(a);

		// tracking counts of numbers
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : a) map.put(num, map.getOrDefault(num, 0) + 1);

		for (int i = 0; i < n; i++) {
			// avoid duplicate triplets of a[i]
			if (i > 0 && a[i] == a[i - 1]) continue;
			for (int j = i + 1; j < n; j++) {
				// a[j] >= a[i] but has to be distinct
				if (j > i + 1 && a[j] == a[j - 1]) continue;

				int cur = 0 - a[i] - a[j];
				// avoid triplets by setting cur >= a[j]
				if (cur >= a[j]) {
					map.put(a[i], map.get(a[i]) - 1);
					map.put(a[j], map.get(a[j]) - 1);

					if (map.containsKey(cur) && map.get(cur) > 0) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(a[i]);
						tmp.add(a[j]);
						tmp.add(cur);
						System.out.println(tmp.get(0) + ", " + tmp.get(1) + ", " + tmp.get(2));
					}

					// reset
					map.put(a[i], map.get(a[i]) + 1);
					map.put(a[j], map.get(a[j]) + 1);
				}
			}
		}
	}

}
