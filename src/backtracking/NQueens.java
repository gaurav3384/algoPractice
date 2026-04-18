package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: N-Queens
 * Concepts: Array, Backtracking
 * 
 * Description:
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
 * such that no two queens attack each other.
 * Return all distinct solutions.
 */
public class NQueens {

    /**
     * Solution: Backtracking (Optimal)
     * Strategy: Place queens row by row. 
     * Keep track of occupied columns, positive diagonals (r+c), and negative diagonals (r-c).
     * 
     * Time Complexity: O(N!)
     * Space Complexity: O(N)
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }
        
        backtrack(0, n, board, res);
        return res;
    }

    private void backtrack(int r, int n, char[][] board, List<List<String>> res) {
        if (r == n) {
            res.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (isValid(r, c, n, board)) {
                board[r][c] = 'Q';
                backtrack(r + 1, n, board, res);
                board[r][c] = '.'; // backtrack
            }
        }
    }

    private boolean isValid(int r, int c, int n, char[][] board) {
        // Check column
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') return false;
        }
        // Check top-left diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // Check top-right diagonal
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        System.out.println("Solutions for 4-Queens: " + solver.solveNQueens(4).size()); // 2
    }
}
