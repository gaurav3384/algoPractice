package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Problem: Daily Temperatures
 * Concepts: Array, Stack, Monotonic Stack
 * 
 * Description:
 * Given an array of integers temperatures represents the daily temperatures, return an array 
 * answer such that answer[i] is the number of days you have to wait after the ith day 
 * to get a warmer temperature. If there is no future day for which this is possible, 
 * keep answer[i] == 0 instead.
 */
public class DailyTemperatures {

    /**
     * Solution: Monotonic Stack (Optimal)
     * Strategy: Use a stack to store the indices of the temperatures.
     * When a warmer temperature is found, pop the stack and calculate the difference in indices.
     * 
     * Time Complexity: O(n) - Each element is pushed and popped at most once.
     * Space Complexity: O(n) - In the worst case, the stack stores all indices.
     * 
     * Example: temperatures = [73,74,75,71,69,72,76,73] -> Output: [1,1,4,2,1,1,0,0]
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>(); // Monotonic decreasing stack (stores indices)
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures solver = new DailyTemperatures();
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println("Wait Days: " + Arrays.toString(solver.dailyTemperatures(temps)));
    }
}
