package dynamic_programming_1d;

import java.util.Arrays;

/**
 * Problem: Coin Change
 * Concepts: Array, Dynamic Programming, Breadth-First Search
 * 
 * Description:
 * You are given an integer array coins representing coins of different denominations 
 * and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange {

    /**
     * Solution: Iterative DP Bottom-Up (Optimal)
     * Strategy: dp[i] stores the min coins for amount i.
     * dp[i] = min(dp[i], 1 + dp[i - coin]) for each coin in coins.
     * 
     * Time Complexity: O(amount * n) where n is number of coins.
     * Space Complexity: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        
        return (dp[amount] > amount) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange solver = new CoinChange();
        int[] coins = {1, 2, 5};
        System.out.println("Min coins for 11: " + solver.coinChange(coins, 11)); // 3 (5+5+1)
    }
}
