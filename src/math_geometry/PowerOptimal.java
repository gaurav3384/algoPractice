package math_geometry;

/**
 * Problem: Pow(x, n)
 */
public class PowerOptimal {

    /**
     * Solution: Iterative Binary Exponentiation (Optimal)
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double currentProd = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                ans = ans * currentProd;
            }
            currentProd = currentProd * currentProd;
        }
        return ans;
    }

    public static void main(String[] args) {
        PowerOptimal solver = new PowerOptimal();
        System.out.println("Result: " + solver.myPow(2.0, 10));
    }
}
