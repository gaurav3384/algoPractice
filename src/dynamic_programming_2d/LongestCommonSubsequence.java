package dynamic_programming_2d;

/**
 * Problem: Longest Common Subsequence
 * Concepts: String, Dynamic Programming
 * 
 * Description:
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {

    /**
     * Solution: 2D Dynamic Programming (Optimal)
     * Strategy:
     * dp[i][j] stores the LCS of text1[0...i-1] and text2[0...j-1].
     * 1. If text1[i-1] == text2[j-1], dp[i][j] = 1 + dp[i-1][j-1]
     * 2. Else, dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solver = new LongestCommonSubsequence();
        System.out.println("LCS: " + solver.longestCommonSubsequence("abcde", "ace")); // 3
    }
}
