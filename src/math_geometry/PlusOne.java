package math_geometry;

import java.util.Arrays;

/**
 * Problem: Plus One
 * Concepts: Array, Math
 * 
 * Description:
 * You are given a large integer represented as an integer array digits. 
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    /**
     * Solution: Iterative with Carry (Optimal)
     * Strategy: Traverse from right to left. If digit is < 9, increment and return. 
     * If 9, set to 0 and continue. If all are 9, create a new array with 1 followed by 0s.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N) in the worst case (all 9s).
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOne solver = new PlusOne();
        int[] digits = {1, 2, 3};
        System.out.println("Result: " + Arrays.toString(solver.plusOne(digits))); // [1,2,4]
    }
}
