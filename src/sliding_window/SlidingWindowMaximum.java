package sliding_window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem: Sliding Window Maximum
 * Concepts: Array, Queue, Sliding Window, Deque, Heap
 * 
 * Description:
 * You are given an array of integers nums, there is a sliding window of size k 
 * which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */
public class SlidingWindowMaximum {

    /**
     * Solution: Deque (Optimal)
     * Strategy: Use a monotonic deque (double-ended queue) to store indices.
     * The deque will maintain elements in decreasing order.
     * 1. Remove indices from the front if they are out of the window.
     * 2. Remove indices from the back if the current element is greater than elements at those indices.
     * 3. The front of the deque always contains the index of the maximum element for the current window.
     * 
     * Time Complexity: O(n) - Each element is added and removed from the deque at most once.
     * Space Complexity: O(k) - Deque stores at most k indices.
     * 
     * Example: nums = [1,3,-1,-3,5,3,6,7], k = 3 -> Output: [3,3,5,5,6,7]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of bounds (left side of window)
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // Maintain monotonic property: remove elements smaller than current from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
            
            // Add to result if window has reached size k
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Result: " + Arrays.toString(solver.maxSlidingWindow(nums, k)));
    }
}
