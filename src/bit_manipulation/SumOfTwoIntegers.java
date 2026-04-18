package bit_manipulation;

/**
 * Problem: Sum of Two Integers
 * Concepts: Math, Bit Manipulation
 * 
 * Description:
 * Given two integers a and b, return the sum of the two integers without 
 * using the operators + and -.
 */
public class SumOfTwoIntegers {

    /**
     * Solution: Bitwise Addition (Optimal)
     * Strategy:
     * - a ^ b calculates the sum without carry.
     * - (a & b) << 1 calculates the carry.
     * Repeat until carry becomes 0.
     * 
     * Time Complexity: O(1) - or more specifically, proportional to word size (32).
     * Space Complexity: O(1)
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solver = new SumOfTwoIntegers();
        System.out.println("Sum of 2 and 3: " + solver.getSum(2, 3)); // 5
    }
}
