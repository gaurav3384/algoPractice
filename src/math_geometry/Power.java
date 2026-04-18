package math_geometry;

/**
 * Problem: Pow(x, n)
 * Concepts: Math, Binary Exponentiation, Recursion
 * 
 * Description:
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */
public class Power {

    /**
     * Solution: Binary Exponentiation (Optimal)
     * Strategy: 
     * - If n is even, x^n = (x^2)^(n/2)
     * - If n is odd, x^n = x * x^(n-1)
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Power solver = new Power();
        System.out.println("2^10: " + solver.myPow(2.0, 10)); // 1024.0
    }
}
