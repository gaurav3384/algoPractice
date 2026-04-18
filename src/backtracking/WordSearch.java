package backtracking;

/**
 * Problem: Word Search
 * Concepts: Array, Backtracking
 * 
 * Description:
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 */
public class WordSearch {

    /**
     * Solution: Backtracking / DFS (Optimal)
     * Strategy: Try to find the word starting from each cell. 
     * Perform DFS to explore adjacent cells, marking visited cells temporarily.
     * 
     * Time Complexity: O(N * 3^L) where N is cells and L is word length.
     * Space Complexity: O(L)
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int index) {
        if (index == word.length()) return true;
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || 
            board[r][c] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[r][c];
        board[r][c] = '#'; // mark as visited
        
        boolean found = dfs(board, r + 1, c, word, index + 1) ||
                        dfs(board, r - 1, c, word, index + 1) ||
                        dfs(board, r, c + 1, word, index + 1) ||
                        dfs(board, r, c - 1, word, index + 1);
        
        board[r][c] = temp; // backtrack
        return found;
    }

    public static void main(String[] args) {
        WordSearch solver = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        System.out.println("Exists: " + solver.exist(board, "ABCCED")); // true
    }
}
