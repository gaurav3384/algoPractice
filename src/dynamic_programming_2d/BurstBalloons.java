package dynamic_programming_2d;

/**
 * Problem: Burst Balloons
 * Concepts: Array, Dynamic Programming
 * 
 * Description:
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with 
 * a number on it represented by an array nums. You are asked to burst all the balloons.
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. 
 * After the burst, nums[i - 1] and nums[i + 1] then becomes adjacent.
 * Return the maximum coins you can collect by bursting the balloons wisely.
 */
public class BurstBalloons {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: Think in reverse. What is the LAST balloon to burst in interval [i, j]?
     * dp[i][j] = max coins from bursting balloons in interval [i...j].
     * last balloon k gives: nums[i-1] * nums[k] * nums[j+1] + dp[i][k-1] + dp[k+1][j].
     * 
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = 1; val[n + 1] = 1;
        for (int i = 0; i < n; i++) val[i + 1] = nums[i];
        
        int[][] dp = new int[n + 2][n + 2];
        
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], 
                               val[i - 1] * val[k] * val[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }
        
        return dp[1][n];
    }

    public static void main(String[] args) {
        BurstBalloons solver = new BurstBalloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println("Max Coins: " + solver.maxCoins(nums)); // 167
    }
}
