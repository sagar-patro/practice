package com.practice.sp.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    //Leetcode# 347: https://leetcode.com/problems/top-k-frequent-elements/

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int l = 0;
        int[] result = new int[k];

        //Keep count of all the elements
        //Starting with -1 so that we have 0 based index later
        for(int n: nums) {
            countMap.put(n, countMap.getOrDefault(n, -1) + 1);
        }

        List<Integer>[] frequency = new ArrayList[nums.length];

        // frequency array need to contain unique elements based on their count
        countMap.forEach((key, value) -> {
            if (frequency[value] == null) frequency[value] = new ArrayList<>();
            frequency[value].add(key);
        });

        for(int i = frequency.length - 1; i >= 0 && l < k; i--) {
            if(frequency[i] != null) {
                for(int j = 0; j < frequency[i].size() && l < k; j++) {
                    result[l++] = frequency[i].get(j);
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        topKFrequent(nums, 2);
    }
}
