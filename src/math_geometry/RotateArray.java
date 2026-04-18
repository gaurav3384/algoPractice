package math_geometry;

import java.util.Arrays;

/**
 * Problem: Rotate Array
 * Concepts: Array, Math, Two Pointers
 * 
 * Description:
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {

    /**
     * Solution: Triple Reverse (Optimal)
     * Strategy:
     * 1. Reverse the entire array.
     * 2. Reverse the first k elements.
     * 3. Reverse the rest (n-k elements).
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Handle k > n
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray solver = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solver.rotate(nums, 3);
        System.out.println("Result: " + Arrays.toString(nums)); // [5,6,7,1,2,3,4]
    }
}
