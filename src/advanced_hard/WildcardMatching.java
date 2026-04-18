package advanced_hard;

/**
 * Problem: Wildcard Matching
 * Concepts: String, Dynamic Programming, Greedy, Two Pointers
 * 
 * Description:
 * Given an input string s and a pattern p, implement wildcard pattern matching 
 * with support for '?' and '*' where:
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 */
public class WildcardMatching {

    /**
     * Solution: Two Pointers / Greedy (Optimal)
     * Strategy:
     * 1. Use pointers for s and p. 
     * 2. If chars match or p is '?', advance both.
     * 3. If p is '*', mark the star position and current s position as anchor.
     * 4. If mismatch, backtrack to the last '*' anchor and try matching more chars in s.
     * 
     * Time Complexity: O(M * N) worst case, O(M + N) average.
     * Space Complexity: O(1)
     */
    public boolean isMatch(String s, String p) {
        int sPtr = 0, pPtr = 0;
        int starIdx = -1, sTmpIdx = -1;
        
        while (sPtr < s.length()) {
            if (pPtr < p.length() && (p.charAt(pPtr) == '?' || p.charAt(pPtr) == s.charAt(sPtr))) {
                sPtr++;
                pPtr++;
            } else if (pPtr < p.length() && p.charAt(pPtr) == '*') {
                starIdx = pPtr;
                sTmpIdx = sPtr;
                pPtr++;
            } else if (starIdx == -1) {
                return false;
            } else {
                pPtr = starIdx + 1;
                sTmpIdx++;
                sPtr = sTmpIdx;
            }
        }
        
        for (int i = pPtr; i < p.length(); i++) {
            if (p.charAt(i) != '*') return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        WildcardMatching solver = new WildcardMatching();
        System.out.println("Match adceb with *a*b: " + solver.isMatch("adceb", "*a*b")); // true
    }
}
