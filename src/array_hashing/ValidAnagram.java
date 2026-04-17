package array_hashing;

import java.util.Arrays;

/**
 * Problem: Valid Anagram
 * Concepts: Array, Hash Table, Sorting
 * 
 * Description:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
 * typically using all the original letters exactly once.
 */
public class ValidAnagram {

    /**
     * Solution 1: Sorting
     * Strategy: Anagrams contain the same characters with the same frequencies. 
     * If we sort both strings, they should be identical.
     * 
     * Time Complexity: O(n log n) - Due to sorting, where n is the length of the string.
     * Space Complexity: O(n) or O(1) - Depending on the language's string-to-char-array implementation.
     * 
     * Example: s = "anagram", t = "nagaram" -> Output: true
     */
    public boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    /**
     * Solution 2: Frequency Counter (Optimal)
     * Strategy: Use an array of size 26 (for lowercase English letters) to count character frequencies.
     * Increment for string s and decrement for string t. If all counts are zero, they are anagrams.
     * 
     * Time Complexity: O(n) - One pass through the strings.
     * Space Complexity: O(1) - The frequency array size is constant (26).
     * 
     * Example: s = "rat", t = "car" -> Output: false
     */
    public boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        
        for (int count : counts) {
            if (count != 0) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solver = new ValidAnagram();
        String s = "anagram", t = "nagaram";
        System.out.println("Is Anagram: " + solver.isAnagramOptimal(s, t));
    }
}
