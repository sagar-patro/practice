package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TwoSum {


	public static void main(String[] args) {
		int[] n = {-1,0,1,2,-1,-4};

		List<Integer> weights = new ArrayList<>();

		weights.add(1);
		weights.add(2);
		weights.add(3);

		System.out.println(weights.subList(0, 3));
	}

	public static List<List<Integer>> threeSum(int[] n) {
		if(n.length < 3) return Collections.emptyList();

		List<List<Integer>> result = new LinkedList<>();

		for(int i = 0; i < n.length; i++) {
			int sum = 0 - n[i];
			System.out.println("sum: " + sum);

			int[] otherTwo= find2Sum(n, sum, i);

			if(otherTwo.length == 2) {
				List<Integer> temp = new LinkedList<>();
				temp.add(n[i]);
				temp.add(n[otherTwo[0]]);
				temp.add(n[otherTwo[1]]);

				result.add(temp);
			}
		}
		return result;
	}

	private static int[] find2Sum(int[] nums, int sum, int indexToAvoid) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < nums.length; i++) {
			if(i == indexToAvoid) continue;

			int complement = sum - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}

		return new int[0];
	}

}
