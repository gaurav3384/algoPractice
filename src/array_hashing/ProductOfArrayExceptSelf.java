package array_hashing;

import java.util.Arrays;

/**
 * Problem: Product of Array Except Self
 * Concepts: Array, Prefix Product
 * 
 * Description:
 * Given an integer array nums, return an array answer such that answer[i] is equal 
 * to the product of all the elements of nums except nums[i].
 * The algorithm must run in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Solution 1: Prefix and Suffix Products (Space O(n))
     * Strategy: Create two arrays 'prefix' and 'suffix'. 
     * prefix[i] stores product of all elements to the left of i.
     * suffix[i] stores product of all elements to the right of i.
     * answer[i] = prefix[i] * suffix[i].
     * 
     * Time Complexity: O(n) - Three passes through the array.
     * Space Complexity: O(n) - Using two extra arrays.
     * 
     * Example: nums = [1,2,3,4] -> prefix = [1,1,2,6], suffix = [24,12,4,1] -> Output: [24,12,8,6]
     */
    public int[] productExceptSelfWithExtraSpace(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    /**
     * Solution 2: Optimal Space (Space O(1) extra space)
     * Strategy: Use the result array to store prefix products first.
     * Then iterate backward to multiply with suffix products using a single variable.
     * 
     * Time Complexity: O(n) - Two passes through the array.
     * Space Complexity: O(1) - Extra space (ignoring the output array).
     * 
     * Example: nums = [-1,1,0,-3,3] -> Output: [0,0,9,0,0]
     */
    public int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: Compute prefix products directly into result array
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Second pass: Multiply with suffix products using a variable
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solver = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println("Result: " + Arrays.toString(solver.productExceptSelfOptimal(nums)));
    }
}
