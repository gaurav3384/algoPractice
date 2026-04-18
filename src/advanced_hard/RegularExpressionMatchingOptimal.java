package advanced_hard;

/**
 * Problem: Regular Expression Matching
 */
public class RegularExpressionMatchingOptimal {

    /**
     * Solution: Iterative 2D DP (Optimal)
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 2; j <= n; j++) if (p.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2]; // match 0
                    if (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.') {
                        dp[i][j] |= dp[i-1][j]; // match 1+
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatchingOptimal solver = new RegularExpressionMatchingOptimal();
        System.out.println("Result: " + solver.isMatch("aa", "a*"));
    }
}
