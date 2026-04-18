package dynamic_programming_2d;

import java.util.Arrays;

/**
 * Problem: Unique Paths
 * Concepts: Array, Dynamic Programming, Combinatorics
 * 
 * Description:
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner.
 * The robot tries to move to the bottom-right corner. The robot can only move 
 * either down or right at any point in time.
 * Return the number of possible unique paths.
 */
public class UniquePaths {

    /**
     * Solution: 2D Dynamic Programming (Optimal)
     * Strategy: dp[i][j] = dp[i-1][j] + dp[i][j-1].
     * 1. To reach current cell, robot must have come from top or left.
     * 2. Initialize first row and first column to 1.
     * 
     * Time Complexity: O(m * n)
     * Space Complexity: O(n) - Space optimized to use only one row.
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solver = new UniquePaths();
        System.out.println("Paths for 3x7: " + solver.uniquePaths(3, 7)); // 28
    }
}
