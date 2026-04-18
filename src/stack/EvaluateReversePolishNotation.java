package stack;

import java.util.Stack;

/**
 * Problem: Evaluate Reverse Polish Notation
 * Concepts: Array, Math, Stack
 * 
 * Description:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation (RPN).
 * Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
 */
public class EvaluateReversePolishNotation {

    /**
     * Solution: Stack (Optimal)
     * Strategy: Push numbers onto the stack. When an operator is encountered, 
     * pop the last two numbers, apply the operator, and push the result back.
     * 
     * Time Complexity: O(n) - One pass through the tokens.
     * Space Complexity: O(n) - Stack stores operands.
     * 
     * Example: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String t : tokens) {
            if (t.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (t.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (t.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (t.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation solver = new EvaluateReversePolishNotation();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println("Result: " + solver.evalRPN(tokens));
    }
}
