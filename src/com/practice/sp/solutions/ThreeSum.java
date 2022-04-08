package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
//		int[] nums = {0, 0, 0};
		int[] nums = {-2, 0, 0, 2, 3};

		System.out.println(
				threeSum(nums)
		);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		HashSet<List<Integer>> hashSet = new HashSet<>();

		for(int i = 0; i < nums.length; i++){
			int l = i + 1;
			int r = nums.length - 1;
			while(l < r){
				int sum = nums[i] + nums[l] + nums[r];
				if(sum == 0) {
					hashSet.add(
							Arrays.asList(nums[i], nums[l], nums[r])
					);
				}
				if(sum > 0) {
					r--;
				} else {
					l++;
				}
			}
		}
		return new ArrayList<>(hashSet);
	}

}
