package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Palindrome Partitioning
 * Concepts: String, Backtracking, Dynamic Programming
 * 
 * Description:
 * Given a string s, partition s such that every substring of the partition is a palindrome. 
 * Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {

    /**
     * Solution: Backtracking (Optimal)
     * Strategy: Iterate through possible substring lengths starting from index '0'. 
     * If the current substring is a palindrome, recurse for the remainder.
     * 
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N)
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, String s, List<String> current, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                current.add(s.substring(start, i + 1));
                backtrack(i + 1, s, current, res);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();
        System.out.println("Partitions: " + solver.partition("aab"));
    }
}
