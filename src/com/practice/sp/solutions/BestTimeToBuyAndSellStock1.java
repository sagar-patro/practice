package com.practice.sp.solutions;

/**
 * Leetcode# 121
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock1 {
    public int maxProfit(int[] prices) {
        int buyingDay = prices[0];

        int profit = Integer.MAX_VALUE;

        for(int i = 1; i < prices.length; i++) {
            int sellingPrice = buyingDay - prices[i];

            if(sellingPrice >= 0) buyingDay = prices[i];
            else if(profit > sellingPrice) {
                profit = sellingPrice;
            }
        }

        if(profit < 0) return Math.abs(profit);
        else return 0;
    }
}
