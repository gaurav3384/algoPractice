package stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Generate Parentheses
 * Concepts: String, Dynamic Programming, Backtracking
 * 
 * Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {

    /**
     * Solution: Backtracking (Optimal)
     * Strategy: Keep track of the number of open and closed parentheses used.
     * 1. Add an open parenthesis if open < n.
     * 2. Add a closed parenthesis if close < open.
     * 
     * Time Complexity: O(4^n / sqrt(n)) - n-th Catalan number.
     * Space Complexity: O(n) - Recursion stack and current string length.
     * 
     * Example: n = 3 -> Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            res.add(current);
            return;
        }

        if (open < max) {
            backtrack(res, current + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses solver = new GenerateParentheses();
        System.out.println("Result (n=3): " + solver.generateParenthesis(3));
    }
}
