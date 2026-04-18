package bit_manipulation;

/**
 * Problem: Missing Number
 * Concepts: Array, Math, Bit Manipulation
 * 
 * Description:
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 */
public class MissingNumber {

    /**
     * Solution 1: Gauss' Sum Formula (Optimal)
     * Strategy: Expected sum = n*(n+1)/2. Result = Expected Sum - Actual Sum.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int missingNumberSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int x : nums) actualSum += x;
        return expectedSum - actualSum;
    }

    /**
     * Solution 2: XOR (Optimal)
     * Strategy: XORing all numbers from 0 to n and all numbers in the array. 
     * The missing number will remain.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int missingNumberXOR(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        MissingNumber solver = new MissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println("Missing (Sum): " + solver.missingNumberSum(nums)); // 2
        System.out.println("Missing (XOR): " + solver.missingNumberXOR(nums)); // 2
    }
}
