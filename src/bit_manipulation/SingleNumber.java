package bit_manipulation;

/**
 * Problem: Single Number
 * Concepts: Array, Bit Manipulation
 * 
 * Description:
 * Given a non-empty array of integers nums, every element appears twice except 
 * for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only 
 * constant extra space.
 */
public class SingleNumber {

    /**
     * Solution: XOR (Optimal)
     * Strategy: 
     * - n ^ 0 = n
     * - n ^ n = 0
     * - XOR is commutative and associative.
     * XORing all numbers together will leave only the single number.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) res ^= n;
        return res;
    }

    public static void main(String[] args) {
        SingleNumber solver = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("Single: " + solver.singleNumber(nums)); // 4
    }
}
