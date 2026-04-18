package math_geometry;

/**
 * Problem: Multiply Strings
 */
public class MultiplyStringsOptimal {

    /**
     * Solution: Simulation (Optimal)
     * Time Complexity: O(M * N)
     * Space Complexity: O(M + N)
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int p : res) if (!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStringsOptimal solver = new MultiplyStringsOptimal();
        System.out.println("Result: " + solver.multiply("12", "12"));
    }
}
