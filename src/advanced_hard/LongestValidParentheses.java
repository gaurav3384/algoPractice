package advanced_hard;

import java.util.Stack;

/**
 * Problem: Longest Valid Parentheses
 * Concepts: String, Dynamic Programming, Stack
 * 
 * Description:
 * Given a string containing just the characters '(' and ')', find the length 
 * of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParentheses {

    /**
     * Solution 1: Stack (Optimal)
     * Strategy: Store indices in the stack. 
     * 1. Initialize stack with -1.
     * 2. If '(', push index.
     * 3. If ')', pop. If stack empty, push current index as new anchor. 
     *    Else, currentLen = i - stack.peek().
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestValidParentheses solver = new LongestValidParentheses();
        System.out.println("Longest for )()()) : " + solver.longestValidParentheses(")()())")); // 4
    }
}
