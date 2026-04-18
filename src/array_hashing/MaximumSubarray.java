package array_hashing;

/**
 * Problem: Maximum Subarray
 * Concepts: Array, Dynamic Programming, Divide and Conquer
 * 
 * Description:
 * Given an integer array nums, find the subarray with the largest sum and return its sum.
 */
public class MaximumSubarray {

    /**
     * Solution 1: Brute Force (Space O(1))
     * Strategy: Calculate the sum of all possible subarrays and keep track of the maximum.
     * 
     * Time Complexity: O(n^2) - Nested loops for subarray start and end.
     * Space Complexity: O(1) - No extra space.
     * 
     * Example: nums = [-2,1,-3,4,-1,2,1,-5,4] -> Output: 6 ([4,-1,2,1])
     */
    public int maxSubArrayBruteForce(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    /**
     * Solution 2: Kadane's Algorithm (Optimal)
     * Strategy: Iterate through the array, keeping track of the maximum sum ending at the current position.
     * If the current subarray sum becomes negative, reset it to 0 and start a new subarray.
     * 
     * Time Complexity: O(n) - One pass through the array.
     * Space Complexity: O(1) - Only a few variables used.
     * 
     * Example: nums = [1] -> Output: 1
     */
    public int maxSubArrayOptimal(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        
        for (int num : nums) {
            // If currentSum is negative, it's better to start a new subarray from 'num'
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    /**
     * Solution 3: Divide and Conquer
     * Strategy: Split the array in half. The max subarray is either in the left half, 
     * the right half, or crossing the midpoint.
     * 
     * Time Complexity: O(n log n) - Standard divide and conquer complexity.
     * Space Complexity: O(log n) - Recursion stack.
     */
    public int maxSubArrayDivideConquer(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    private int solve(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        
        int mid = left + (right - left) / 2;
        int leftSum = solve(nums, left, mid);
        int rightSum = solve(nums, mid + 1, right);
        int crossSum = crossMidSum(nums, left, mid, right);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int crossMidSum(int[] nums, int left, int mid, int right) {
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }
        
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }
        
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        MaximumSubarray solver = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Subarray Sum: " + solver.maxSubArrayOptimal(nums));
    }
}
