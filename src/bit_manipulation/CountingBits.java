package bit_manipulation;

import java.util.Arrays;

/**
 * Problem: Counting Bits
 * Concepts: Dynamic Programming, Bit Manipulation
 * 
 * Description:
 * Given an integer n, return an array ans of length n + 1 such that for 
 * each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */
public class CountingBits {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: count(i) = count(i / 2) + (i % 2).
     * i / 2 is the same as i >> 1, and i % 2 is the same as i & 1.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Result array.
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i >> 1 has already been calculated
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits solver = new CountingBits();
        System.out.println("Result (n=5): " + Arrays.toString(solver.countBits(5))); // [0,1,1,2,1,2]
    }
}
