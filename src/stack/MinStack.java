package stack;

import java.util.Stack;

/**
 * Problem: Min Stack
 * Concepts: Stack, Design
 * 
 * Description:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * Solution: Two Stacks (Optimal)
     * Strategy: Use one stack to store all values and a second 'minStack' to store 
     * the current minimum at each level.
     * 
     * Time Complexity: O(1) for all operations.
     * Space Complexity: O(n) to store the values.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Min: " + minStack.getMin()); // -3
        minStack.pop();
        System.out.println("Top: " + minStack.top());    // 0
        System.out.println("Min: " + minStack.getMin()); // -2
    }
}
