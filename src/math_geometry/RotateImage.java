package math_geometry;

import java.util.Arrays;

/**
 * Problem: Rotate Image
 * Concepts: Array, Matrix
 * 
 * Description:
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 
 * degrees (clockwise). You have to rotate the image in-place.
 */
public class RotateImage {

    /**
     * Solution: Transpose and Flip (Optimal)
     * Strategy: 
     * 1. Transpose the matrix (swap matrix[i][j] with matrix[j][i]).
     * 2. Reverse each row.
     * Result is a 90-degree clockwise rotation.
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // 1. Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // 2. Reverse rows
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage solver = new RotateImage();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        solver.rotate(matrix);
        System.out.println("Rotated: " + Arrays.deepToString(matrix)); // [[7,4,1],[8,5,2],[9,6,3]]
    }
}
