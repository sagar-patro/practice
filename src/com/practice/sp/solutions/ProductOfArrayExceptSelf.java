package com.practice.sp.solutions;

import java.util.Arrays;

/**
 * Leetcode# 238
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefix = 1;
        int postfix = 1;

        //Calculate the products of numbers left of nums[i]
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) prefix = 1;
            else prefix *= nums[i - 1];

            result[i] = prefix;
        }

        //Calculate the products of numbers right of nums[i]
        //and multiply the same with left side products
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) postfix = 1;
            else postfix *= nums[i + 1];

            result[i] *= postfix;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Arrays.stream(productExceptSelf(nums)).boxed().forEach(System.out::println);
    }
}
