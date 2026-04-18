package bit_manipulation;

/**
 * Problem: Number of 1 Bits
 * Concepts: Math, Bit Manipulation
 * 
 * Description:
 * Write a function that takes an unsigned integer and returns the number of 
 * '1' bits it has (also known as the Hamming weight).
 */
public class HammingWeight {

    /**
     * Solution: Brian Kernighan's Algorithm (Optimal)
     * Strategy: n & (n - 1) flips the least significant set bit to 0. 
     * Repeat until n becomes 0.
     * 
     * Time Complexity: O(1) - or more specifically, O(number of 1 bits). 
     * In Java, an int is 32 bits, so it's constant time.
     * Space Complexity: O(1)
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight solver = new HammingWeight();
        System.out.println("Hamming: " + solver.hammingWeight(11)); // 11 is 1011 -> 3
    }
}
