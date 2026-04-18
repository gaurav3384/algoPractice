package bit_manipulation;

/**
 * Problem: Reverse Bits
 * Concepts: Math, Bit Manipulation
 * 
 * Description:
 * Reverse bits of a given 32 bits unsigned integer.
 */
public class ReverseBits {

    /**
     * Solution: Bit-by-bit manipulation (Optimal)
     * Strategy: Iterate through all 32 bits. 
     * In each step, shift the result to the left, and add the last bit of the input.
     * 
     * Time Complexity: O(1) - Constant 32 iterations.
     * Space Complexity: O(1)
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits solver = new ReverseBits();
        // Input: 00000010100101000001111010011100 (43261596)
        // Output: 00111001011110000010100101000000 (964176192)
        System.out.println("Reversed: " + solver.reverseBits(43261596));
    }
}
