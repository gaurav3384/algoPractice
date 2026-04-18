package dynamic_programming_2d;

/**
 * Problem: Edit Distance
 * Concepts: String, Dynamic Programming
 * 
 * Description:
 * Given two strings word1 and word2, return the minimum number of operations 
 * required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * 1. Insert a character
 * 2. Delete a character
 * 3. Replace a character
 */
public class EditDistance {

    /**
     * Solution: 2D Dynamic Programming (Optimal)
     * Strategy: dp[i][j] stores the edit distance between word1[0...i-1] and word2[0...j-1].
     * 1. If word1[i-1] == word2[j-1], dp[i][j] = dp[i-1][j-1].
     * 2. Else, dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) 
     *    (Replace, Delete, Insert).
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance solver = new EditDistance();
        System.out.println("Distance: " + solver.minDistance("horse", "ros")); // 3
    }
}
