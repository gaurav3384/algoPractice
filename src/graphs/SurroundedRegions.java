package graphs;

/**
 * Problem: Surrounded Regions
 * Concepts: Array, Depth-First Search, Breadth-First Search, Union Find
 * 
 * Description:
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 
 * 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class SurroundedRegions {

    /**
     * Solution: DFS from Boundaries (Optimal)
     * Strategy: Any 'O' connected to the boundary cannot be captured.
     * 1. Traverse all boundary cells. If 'O', trigger DFS to mark all connected 'O's with a temporary '#'.
     * 2. Flip all remaining 'O's to 'X's (surrounded).
     * 3. Restore '#' to 'O'.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        
        // Mark uncapturable 'O's from boundaries
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        
        // Final pass: Capture and Restore
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] b, int r, int c) {
        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length || b[r][c] != 'O') return;
        b[r][c] = '#';
        dfs(b, r + 1, c);
        dfs(b, r - 1, c);
        dfs(b, r, c + 1);
        dfs(b, r, c - 1);
    }

    public static void main(String[] args) {
        SurroundedRegions solver = new SurroundedRegions();
        char[][] board = {{'X','X','X','X'}, {'X','O','O','X'}, {'X','X','O','X'}, {'X','O','X','X'}};
        solver.solve(board);
        System.out.println("Row 1: " + new String(board[1])); // XOOX -> XXXX (Wait, O connected to boundary at [2][2]?)
    }
}
