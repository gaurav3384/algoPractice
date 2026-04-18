package math_geometry;

import java.util.Arrays;

/**
 * Problem: Rotate Image
 * Concepts: Matrix, Array
 */
public class RotateImageOptimal {

    /**
     * Solution: Transpose and Reflect (Optimal)
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImageOptimal solver = new RotateImageOptimal();
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
        solver.rotate(m);
        System.out.println("Result: " + Arrays.deepToString(m));
    }
}
