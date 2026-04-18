package dynamic_programming_1d;

/**
 * Problem: Palindromic Substrings
 * Concepts: String, Dynamic Programming, Two Pointers
 * 
 * Description:
 * Given a string s, return the number of palindromic substrings in it.
 */
public class PalindromicSubstrings {

    /**
     * Solution: Expand Around Center (Optimal)
     * Strategy: A palindrome can be centered at index i (odd length) or 
     * between index i and i+1 (even length). 
     * For each possible center, expand outward as long as it remains a palindrome.
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);     // Odd length
            count += expand(s, i, i + 1); // Even length
        }
        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings solver = new PalindromicSubstrings();
        System.out.println("Palindromes in aaa: " + solver.countSubstrings("aaa")); // 6
    }
}
