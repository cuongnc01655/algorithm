package main.java.leetcode.dynamicprogramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {1,2,4,1,3,7};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }
//
//    private static int[] maxProfiInShortesPeriod(int[] prices) {
//        int maxProfit = maxProfit(prices);
//        int minPrice = Integer.MAX_VALUE;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minPrice)
//        }
//
//    }
}
