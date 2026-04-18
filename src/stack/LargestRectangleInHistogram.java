package stack;

import java.util.Stack;

/**
 * Problem: Largest Rectangle in Histogram
 * Concepts: Array, Stack, Monotonic Stack
 * 
 * Description:
 * Given an array of integers heights representing the histogram's bar height where 
 * the width of each bar is 1, return the area of the largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {

    /**
     * Solution: Monotonic Stack (Optimal)
     * Strategy: Maintain a monotonic increasing stack of indices.
     * When a height smaller than the top of the stack is encountered, pop elements 
     * and calculate the area of rectangles that can be formed using the popped height as the minimum height.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * Example: heights = [2,1,5,6,2,3] -> Output: 10
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        
        for (int i = 0; i <= n; i++) {
            // Use 0 as a sentinel value at the end to flush the stack
            int h = (i == n) ? 0 : heights[i];
            
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram solver = new LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Area: " + solver.largestRectangleArea(heights));
    }
}
