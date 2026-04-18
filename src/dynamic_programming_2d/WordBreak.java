package dynamic_programming_2d;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: Word Break
 * Concepts: Hash Table, String, Dynamic Programming
 * 
 * Description:
 * Given a string s and a dictionary of strings wordDict, return true if s can 
 * be segmented into a space-separated sequence of one or more dictionary words.
 */
public class WordBreak {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: dp[i] is true if s[0...i-1] can be segmented.
     * 1. For each i from 1 to n, check all j < i.
     * 2. if dp[j] is true and s[j...i-1] is in wordDict, then dp[i] = true.
     * 
     * Time Complexity: O(n^2 * m) where n is s.length and m is max word length.
     * Space Complexity: O(n)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak solver = new WordBreak();
        System.out.println("Can Break: " + solver.wordBreak("leetcode", java.util.Arrays.asList("leet", "code"))); // true
    }
}
