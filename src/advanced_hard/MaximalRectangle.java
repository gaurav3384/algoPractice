package advanced_hard;

import java.util.Stack;

/**
 * Problem: Maximal Rectangle
 * Concepts: Array, Dynamic Programming, Stack, Matrix
 * 
 * Description:
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest 
 * rectangle containing only 1's and return its area.
 */
public class MaximalRectangle {

    /**
     * Solution: Histogram base for each row (Optimal)
     * Strategy:
     * 1. Treat each row as a histogram.
     * 2. For each row, calculate heights of 1s (increment if cell is 1, else reset to 0).
     * 3. For each row's histogram, find the largest rectangle (using logic from Problem 24).
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(N)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        
        for (char[] row : matrix) {
            for (int i = 0; i < n; i++) {
                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleInHistogram(heights));
        }
        
        return maxArea;
    }

    private int largestRectangleInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
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
        MaximalRectangle solver = new MaximalRectangle();
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println("Max Area: " + solver.maximalRectangle(matrix)); // 6
    }
}
