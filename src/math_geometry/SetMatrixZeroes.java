package math_geometry;

import java.util.Arrays;

/**
 * Problem: Set Matrix Zeroes
 * Concepts: Array, Matrix
 * 
 * Description:
 * Given an m x n integer matrix matrix, if an element is 0, set its entire 
 * row and column to 0's. You must do it in-place.
 */
public class SetMatrixZeroes {

    /**
     * Solution: First Row & Column as Markers (Optimal Space)
     * Strategy:
     * 1. Use matrix[i][0] and matrix[0][j] to mark if row i or col j should be zeroed.
     * 2. Use two boolean variables to track if the first row and first column 
     *    themselves should be zeroed.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean rowZero = false, colZero = false;
        
        // Determine if first row/col need to be zeroed
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) colZero = true;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) rowZero = true;
        
        // Use first row/col as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Zero out cells based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // Zero out first row/col if needed
        if (colZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
        if (rowZero) for (int j = 0; j < n; j++) matrix[0][j] = 0;
    }

    public static void main(String[] args) {
        SetMatrixZeroes solver = new SetMatrixZeroes();
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        solver.setZeroes(matrix);
        System.out.println("Result: " + Arrays.deepToString(matrix)); // [[1,0,1],[0,0,0],[1,0,1]]
    }
}
