package sliding_window;

/**
 * Problem: Best Time to Buy and Sell Stock
 * Concepts: Array, Sliding Window, Greedy
 * 
 * Description:
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock 
 * and choosing a different day in the future to sell that stock.
 */
public class BestTimeToBuySellStock {

    /**
     * Solution 1: Brute Force
     * Strategy: Compare every pair of days (i, j) where j > i.
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * Solution 2: One Pass (Optimal)
     * Strategy: Iterate through the array once. Keep track of the minimum price seen so far 
     * and calculate the profit for each subsequent price.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Example: prices = [7,1,5,3,6,4] -> Output: 5
     */
    public int maxProfitOptimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStock solver = new BestTimeToBuySellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + solver.maxProfitOptimal(prices));
    }
}
