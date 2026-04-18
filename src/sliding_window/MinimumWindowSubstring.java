package sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Minimum Window Substring
 * Concepts: Hash Table, String, Sliding Window
 * 
 * Description:
 * Given two strings s and t of lengths m and n respectively, return the minimum window 
 * substring of s such that every character in t (including duplicates) is included in the window. 
 * If there is no such substring, return the empty string "".
 */
public class MinimumWindowSubstring {

    /**
     * Solution: Sliding Window with Two Maps (Optimal)
     * Strategy: 
     * 1. Count frequencies of characters in t.
     * 2. Expand right pointer until the window contains all characters from t.
     * 3. Contract left pointer to find the minimum length while still satisfying the condition.
     * 
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     * 
     * Example: s = "ADOBECODEBANC", t = "ABC" -> Output: "BANC"
     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0, matched = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (targetMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (windowMap.get(c).equals(targetMap.get(c))) {
                    matched++;
                }
            }
            
            // Try shrinking from left when all characters matched
            while (matched == targetMap.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }
                
                char leftChar = s.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    if (windowMap.get(leftChar).equals(targetMap.get(leftChar))) {
                        matched--;
                    }
                    windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring solver = new MinimumWindowSubstring();
        System.out.println("Result: " + solver.minWindow("ADOBECODEBANC", "ABC"));
    }
}
