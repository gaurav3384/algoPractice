package binary_search;

/**
 * Problem: Search a 2D Matrix
 * Concepts: Array, Binary Search, Matrix
 * 
 * Description:
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
 * The matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {

    /**
     * Solution: Treat 2D as 1D Binary Search (Optimal)
     * Strategy: Since the matrix is fully sorted from top-left to bottom-right, 
     * we can treat it as a virtual 1D array of length m * n.
     * index 'i' in 1D -> matrix[i / n][i % n] in 2D.
     * 
     * Time Complexity: O(log(m * n))
     * Space Complexity: O(1)
     * 
     * Example: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 -> true
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];
            
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix solver = new Search2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Found 3: " + solver.searchMatrix(matrix, 3));
    }
}
