package advanced_hard;

/**
 * Problem: First Missing Positive
 * Concepts: Array, Hash Table
 * 
 * Description:
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    /**
     * Solution: In-place Swapping (Optimal)
     * Strategy: Try to put each number x at index x-1 if possible.
     * 1. Iterate through array. If nums[i] is in [1, n], swap it to its correct position.
     * 2. After reordering, the first index i where nums[i] != i + 1 is the result.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive solver = new FirstMissingPositive();
        int[] nums = {3, 4, -1, 1};
        System.out.println("First Missing: " + solver.firstMissingPositive(nums)); // 2
    }
}
