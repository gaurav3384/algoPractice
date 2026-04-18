package dynamic_programming_1d;

/**
 * Problem: Longest Palindromic Substring
 * Concepts: String, Dynamic Programming, Two Pointers
 * 
 * Description:
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubstring {

    /**
     * Solution: Expand Around Center (Optimal)
     * Strategy: Similar to countSubstrings, but keep track of the max length 
     * and its start/end indices.
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);     // Odd
            int len2 = expand(s, i, i + 1); // Even
            int len = Math.max(len1, len2);
            
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solver = new LongestPalindromicSubstring();
        System.out.println("LPS for babad: " + solver.longestPalindrome("babad")); // "bab" or "aba"
    }
}
