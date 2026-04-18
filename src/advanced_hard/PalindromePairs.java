package advanced_hard;

import java.util.*;

/**
 * Problem: Palindrome Pairs
 * Concepts: Hash Table, String, Trie
 * 
 * Description:
 * Given a list of unique words, return all the pairs of the distinct indices 
 * (i, j) in the given list, so that the concatenation of the two words 
 * words[i] + words[j] is a palindrome.
 */
public class PalindromePairs {

    /**
     * Solution: Hash Table Prefix/Suffix Check (Optimal)
     * Strategy:
     * For each word, split it into prefix and suffix.
     * 1. If prefix is a palindrome, check if reversed suffix exists in the map.
     * 2. If suffix is a palindrome, check if reversed prefix exists in the map.
     * 
     * Time Complexity: O(n * k^2) where n is number of words, k is max length.
     * Space Complexity: O(n * k)
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                
                if (isPalindrome(s1)) {
                    String s2rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2rev) && map.get(s2rev) != i) {
                        res.add(Arrays.asList(map.get(s2rev), i));
                    }
                }
                
                if (isPalindrome(s2) && s2.length() != 0) { // s2.length != 0 to avoid duplicates
                    String s1rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1rev) && map.get(s1rev) != i) {
                        res.add(Arrays.asList(i, map.get(s1rev)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs solver = new PalindromePairs();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        System.out.println("Pairs: " + solver.palindromePairs(words)); 
        // [[0,1],[1,0],[3,2],[2,4]]
    }
}
