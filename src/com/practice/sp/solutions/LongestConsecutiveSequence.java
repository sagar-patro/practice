package com.practice.sp.solutions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Leetcode# 128
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed()
                .collect(Collectors.toSet());
        int longest = 0;

        for(int num: nums) {
            if(!set.contains(num-1)) {
                int length = 0;
                while(set.contains(num + length)) {
                    length += 1;
                }
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
