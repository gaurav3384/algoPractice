package advanced_hard;

import java.util.Stack;

/**
 * Problem: Basic Calculator II
 * Concepts: String, Math, Stack
 * 
 * Description:
 * Given a string s which represents an expression, evaluate this expression 
 * and return its value. The expression contains non-negative integers, +, -, *, / 
 * operators and empty spaces.
 */
public class BasicCalculatorII {

    /**
     * Solution: Iterative without explicit Stack (Optimal Space)
     * Strategy: Use a variable 'lastNumber' to handle multiplication and division 
     * precedence before adding to total sum.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        int currentNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        result += lastNumber;
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII solver = new BasicCalculatorII();
        System.out.println("Result: " + solver.calculate("3+2*2")); // 7
    }
}
