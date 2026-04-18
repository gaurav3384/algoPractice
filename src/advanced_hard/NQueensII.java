package advanced_hard;

/**
 * Problem: N-Queens II
 * Concepts: Backtracking
 * 
 * Description:
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
 * such that no two queens attack each other.
 * Return the number of distinct solutions.
 */
public class NQueensII {

    private int count = 0;

    /**
     * Solution: Backtracking with Bitmasks (Optimal)
     * Strategy: Use bitmasks to track occupied columns and diagonals.
     * - cols: vertical attacks.
     * - diag1: positive slope diagonals (r + c).
     * - diag2: negative slope diagonals (r - c).
     * 
     * Time Complexity: O(N!)
     * Space Complexity: O(N)
     */
    public int totalNQueens(int n) {
        backtrack(0, 0, 0, 0, n);
        return count;
    }

    private void backtrack(int row, int cols, int diag1, int diag2, int n) {
        if (row == n) {
            count++;
            return;
        }
        
        // (1 << n) - 1 creates a mask of n ones.
        // ~(cols | diag1 | diag2) finds all available spots as 1s.
        int availablePositions = ((1 << n) - 1) & (~(cols | diag1 | diag2));
        
        while (availablePositions != 0) {
            // Get the lowest set bit
            int position = availablePositions & -availablePositions;
            // Mark position as unavailable
            availablePositions &= ~position;
            
            backtrack(row + 1, 
                      cols | position, 
                      (diag1 | position) << 1, 
                      (diag2 | position) >> 1, 
                      n);
        }
    }

    public static void main(String[] args) {
        NQueensII solver = new NQueensII();
        System.out.println("Total solutions for 8-Queens: " + solver.totalNQueens(8)); // 92
    }
}
