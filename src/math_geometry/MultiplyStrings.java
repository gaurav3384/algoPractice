package math_geometry;

/**
 * Problem: Multiply Strings
 * Concepts: String, Math
 * 
 * Description:
 * Given two non-negative integers num1 and num2 represented as strings, 
 * return the product of num1 and num2, also represented as a string.
 */
public class MultiplyStrings {

    /**
     * Solution: Grade-School Multiplication Simulation (Optimal)
     * Strategy:
     * 1. The product of numbers with lengths L1 and L2 has max length L1 + L2.
     * 2. Use an array to store results of multiplication for each pair of digits.
     * 3. Handle indices carefully: num1[i] * num2[j] contributes to indices [i+j, i+j+1].
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M + N)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int p1 = i + j, p2 = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int p : res) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings solver = new MultiplyStrings();
        System.out.println("123 * 456: " + solver.multiply("123", "456")); // 56088
    }
}
