package sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Longest Substring Without Repeating Characters
 * Concepts: Hash Table, String, Sliding Window
 * 
 * Description:
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChars {

    /**
     * Solution 1: Sliding Window (Set-based)
     * Strategy: Use a set to keep track of characters in the current window.
     * Expand the window to the right and contract from the left if a duplicate is found.
     * 
     * Time Complexity: O(n) - Each character is visited at most twice.
     * Space Complexity: O(min(n, m)) - Set size, where m is the alphabet size.
     */
    public int lengthOfLongestSubstringSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, left = 0, right = 0;
        
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    /**
     * Solution 2: Optimized Sliding Window (Map-based)
     * Strategy: Store the last index of each character in a map. 
     * When a duplicate is found, jump the left pointer directly to the index after the previous occurrence.
     * 
     * Time Complexity: O(n) - One pass.
     * Space Complexity: O(min(n, m)) - Map size.
     * 
     * Example: s = "abcabcbb" -> Output: 3 ("abc")
     */
    public int lengthOfLongestSubstringOptimal(String s) {
        int n = s.length(), res = 0;
        int[] lastIndex = new int[128]; // Assuming ASCII characters
        java.util.Arrays.fill(lastIndex, -1);
        
        for (int right = 0, left = 0; right < n; right++) {
            char c = s.charAt(right);
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }
            res = Math.max(res, right - left + 1);
            lastIndex[c] = right;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars solver = new LongestSubstringWithoutRepeatingChars();
        String s = "pwwkew";
        System.out.println("Max Length: " + solver.lengthOfLongestSubstringOptimal(s));
    }
}
