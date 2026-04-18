package dynamic_programming_2d;

/**
 * Problem: Maximal Square
 * Concepts: Array, Dynamic Programming, Matrix
 * 
 * Description:
 * Given an m x n binary matrix filled with 0's and 1's, find the largest 
 * square containing only 1's and return its area.
 */
public class MaximalSquare {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: dp[i][j] stores the side length of the largest square 
     * ending at matrix[i-1][j-1].
     * 1. If matrix[i-1][j-1] == '1':
     *    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1.
     * 
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) or O(n) if optimized.
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare solver = new MaximalSquare();
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Max Area: " + solver.maximalSquare(matrix)); // 4
    }
}
