package dynamic_programming_1d;

/**
 * Problem: Decode Ways
 * Concepts: String, Dynamic Programming
 * 
 * Description:
 * A message containing letters from A-Z can be encoded into numbers using the mapping:
 * 'A' -> "1", 'B' -> "2", ..., 'Z' -> "26".
 * Given a string s containing only digits, return the number of ways to decode it.
 */
public class DecodeWays {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: dp[i] stores the number of ways to decode the prefix s[0...i-1].
     * 1. If s[i-1] != '0', we can take it as a single digit.
     * 2. If s[i-2...i-1] is between 10 and 26, we can take it as a double digit.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) or O(1) if space-optimized.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            // Single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Two digits
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solver = new DecodeWays();
        System.out.println("Ways for 226: " + solver.numDecodings("226")); // 3 (BZ, VF, BBF)
    }
}
