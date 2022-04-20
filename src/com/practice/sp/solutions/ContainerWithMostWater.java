package com.practice.sp.solutions;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int res = 0;
        int area;
        while(l < r) {
            int left = height[l];
            int right = height[r];

            if(left < right) {
                area = left * (r - l);
                l++;
            } else {
                area = right * (r - l);
                r--;
            }
            res = Math.max(res, area);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {0, 2};
        System.out.println(
                maxArea(height)
        );
    }
}
