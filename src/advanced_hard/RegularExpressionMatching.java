package advanced_hard;

/**
 * Problem: Regular Expression Matching
 * Concepts: String, Dynamic Programming, Recursion
 * 
 * Description:
 * Given an input string s and a pattern p, implement regular expression matching 
 * with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {

    /**
     * Solution: 2D Dynamic Programming (Optimal)
     * Strategy: dp[i][j] is true if s[0...i-1] matches p[0...j-1].
     * 1. If p[j-1] == s[i-1] or '.', dp[i][j] = dp[i-1][j-1].
     * 2. If p[j-1] == '*':
     *    - Matches 0 times: dp[i][j] = dp[i][j-2]
     *    - Matches 1+ times (if preceding char matches): dp[i][j] |= dp[i-1][j]
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Match empty string s with patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // Match 0 preceding
                    dp[i][j] = dp[i][j - 2];
                    
                    // Match 1+ preceding
                    char prevPc = p.charAt(j - 2);
                    if (prevPc == sc || prevPc == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching solver = new RegularExpressionMatching();
        System.out.println("Match aa with a*: " + solver.isMatch("aa", "a*")); // true
    }
}
