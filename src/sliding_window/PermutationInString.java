package sliding_window;

import java.util.Arrays;

/**
 * Problem: Permutation in String
 * Concepts: Hash Table, Two Pointers, String, Sliding Window
 * 
 * Description:
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {

    /**
     * Solution: Sliding Window with Frequency Map (Optimal)
     * Strategy: A permutation of s1 means a substring in s2 with the same character counts as s1.
     * Use an array to store character counts of s1 and a sliding window in s2.
     * 
     * Time Complexity: O(n1 + n2) where n1 and n2 are lengths of s1 and s2.
     * Space Complexity: O(1) - Frequency array of size 26.
     * 
     * Example: s1 = "ab", s2 = "eidbaooo" -> Output: true
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(s1Count, s2Count)) return true;
            
            // Slide window: remove leftmost and add next rightmost
            s2Count[s2.charAt(i) - 'a']--;
            s2Count[s2.charAt(i + s1.length()) - 'a']++;
        }
        
        return Arrays.equals(s1Count, s2Count);
    }

    public static void main(String[] args) {
        PermutationInString solver = new PermutationInString();
        System.out.println("Has Permutation: " + solver.checkInclusion("ab", "eidbaooo"));
    }
}
