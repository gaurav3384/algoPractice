package dynamic_programming_1d;

/**
 * Problem: Longest Palindromic Subsequence
 * Concepts: String, Dynamic Programming
 * 
 * Description:
 * Given a string s, find the longest palindromic subsequence's length in s.
 */
public class LongestPalindromicSubsequence {

    /**
     * Solution: 2D Dynamic Programming (Optimal)
     * Strategy: dp[i][j] stores LPS length for s[i...j].
     * 1. If s[i] == s[j], dp[i][j] = 2 + dp[i+1][j-1]
     * 2. Else, dp[i][j] = max(dp[i+1][j], dp[i][j-1])
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence solver = new LongestPalindromicSubsequence();
        System.out.println("LPS for bbbab: " + solver.longestPalindromeSubseq("bbbab")); // 4
    }
}
