package dynamic_programming_2d;

/**
 * Problem: Minimum Path Sum
 * Concepts: Array, Dynamic Programming, Matrix
 * 
 * Description:
 * Given a m x n grid filled with non-negative numbers, find a path from top left 
 * to bottom right, which minimizes the sum of all numbers along its path.
 * You can only move either down or right at any point in time.
 */
public class MinimumPathSum {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]).
     * 
     * Time Complexity: O(m * n)
     * Space Complexity: O(n) - Optimized to use only one row.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        
        // Initializing dp with first row values
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];
        
        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0]; // Update first element of row
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        
        return dp[n - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum solver = new MinimumPathSum();
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println("Min Sum: " + solver.minPathSum(grid)); // 7
    }
}
