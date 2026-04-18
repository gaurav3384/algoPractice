package array_hashing;

import java.util.Arrays;

/**
 * Problem: Set Matrix Zeroes
 * Concepts: Array, Matrix
 * 
 * Description:
 * Given an m x n integer matrix matrix, if an element is 0, set its entire 
 * row and column to 0's. You must do it in-place.
 */
public class SetMatrixZeroesOptimal {

    /**
     * Solution: O(1) space using first row/col as marker.
     * Time Complexity: O(M * N)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;
        
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstColZero = true;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRowZero = true;
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstColZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (firstRowZero) for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }

    public static void main(String[] args) {
        SetMatrixZeroesOptimal solver = new SetMatrixZeroesOptimal();
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        solver.setZeroes(matrix);
        System.out.println("Result: " + Arrays.deepToString(matrix));
    }
}
