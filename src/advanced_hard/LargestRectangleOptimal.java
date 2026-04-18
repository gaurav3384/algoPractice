package advanced_hard;

import java.util.Stack;

/**
 * Problem: Largest Rectangle in Histogram (Optimal)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LargestRectangleOptimal {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxA = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!s.isEmpty() && h < heights[s.peek()]) {
                int height = heights[s.pop()];
                int width = s.isEmpty() ? i : i - s.peek() - 1;
                maxA = Math.max(maxA, height * width);
            }
            s.push(i);
        }
        return maxA;
    }
}
