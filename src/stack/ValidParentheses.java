package stack;

import java.util.Stack;

/**
 * Problem: Valid Parentheses
 * Concepts: String, Stack
 * 
 * Description:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 */
public class ValidParentheses {

    /**
     * Solution: Stack (Optimal)
     * Strategy: Use a stack to push opening brackets. When a closing bracket is encountered, 
     * check if it matches the top of the stack.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - In the worst case, all characters are opening brackets.
     * 
     * Example: s = "()[]{}" -> true
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solver = new ValidParentheses();
        System.out.println("Is Valid: " + solver.isValid("()[]{}"));
    }
}
