package math_geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Spiral Matrix
 * Concepts: Array, Matrix, Traversal
 * 
 * Description:
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    /**
     * Solution: Simulation with Boundaries (Optimal)
     * Strategy: Define four boundaries (top, bottom, left, right). 
     * Traverse right, then down, then left, then up, shrinking the boundaries after each direction.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(1) - excluding output list.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse Right
            for (int j = left; j <= right; j++) res.add(matrix[top][j]);
            top++;
            
            // Traverse Down
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            
            if (top <= bottom) {
                // Traverse Left
                for (int j = right; j >= left; j--) res.add(matrix[bottom][j]);
                bottom--;
            }
            
            if (left <= right) {
                // Traverse Up
                for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix solver = new SpiralMatrix();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("Spiral: " + solver.spiralOrder(matrix)); // [1,2,3,6,9,8,7,4,5]
    }
}
