package math_geometry;

import java.util.Arrays;

/**
 * Problem: Plus One
 */
public class PlusOneOptimal {

    /**
     * Solution: Iterative Carry (Optimal)
     * Time Complexity: O(N)
     * Space Complexity: O(N) only if new array is needed
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOneOptimal solver = new PlusOneOptimal();
        System.out.println("Result: " + Arrays.toString(solver.plusOne(new int[]{9,9})));
    }
}
