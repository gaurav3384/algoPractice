package array_hashing;

/**
 * Problem: Maximum Product Subarray
 * Concepts: Array, Dynamic Programming
 * 
 * Description:
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 */
public class MaximumProductSubarray {

    /**
     * Solution 1: Brute Force
     * Strategy: Calculate product of all possible subarrays.
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int maxProductBruteForce(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentProd = 1;
            for (int j = i; j < nums.length; j++) {
                currentProd *= nums[j];
                maxProd = Math.max(maxProd, currentProd);
            }
        }
        return maxProd;
    }

    /**
     * Solution 2: Dynamic Programming (Optimal)
     * Strategy: Keep track of both the maximum and minimum product ending at the current position.
     * Since a negative number multiplied by the minimum (most negative) product can result in a new maximum.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * Example: nums = [2,3,-2,4] -> Output: 6
     */
    public int maxProductOptimal(int[] nums) {
        if (nums.length == 0) return 0;
        
        int res = nums[0];
        int curMax = 1;
        int curMin = 1;
        
        for (int num : nums) {
            // If num is 0, it resets curMax and curMin to 1 in the next step, 
            // but we need to consider 0 in the result.
            if (num == 0) {
                curMax = 1;
                curMin = 1;
                res = Math.max(res, 0);
                continue;
            }
            
            int tmpMax = curMax * num;
            curMax = Math.max(num, Math.max(tmpMax, curMin * num));
            curMin = Math.min(num, Math.min(tmpMax, curMin * num));
            
            res = Math.max(res, curMax);
        }
        
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray solver = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println("Max Product: " + solver.maxProductOptimal(nums));
    }
}
