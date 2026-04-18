package sliding_window;

/**
 * Problem: Longest Repeating Character Replacement
 * Concepts: Hash Table, String, Sliding Window
 * 
 * Description:
 * You are given a string s and an integer k. You can choose any character of the string 
 * and change it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepeatingCharReplacement {

    /**
     * Solution: Sliding Window (Optimal)
     * Strategy: Maintain a window [left, right] and a frequency count of characters within it.
     * The number of characters to replace is (windowLength - maxFrequency).
     * if replacements > k, shrink the window from the left.
     * 
     * Time Complexity: O(n) - Single pass through the string.
     * Space Complexity: O(1) - Fixed size array (26 letters).
     * 
     * Example: s = "AABABBA", k = 1 -> Output: 4 ("ABBA" -> "BBBB")
     */
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;
        
        for (int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++counts[s.charAt(right) - 'A']);
            
            // If current replacements required > k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharReplacement solver = new LongestRepeatingCharReplacement();
        System.out.println("Result: " + solver.characterReplacement("AABABBA", 1));
    }
}
