package graphs;

/**
 * Problem: Number of Islands
 * Concepts: Array, Depth-First Search, Breadth-First Search, Union Find
 * 
 * Description:
 * Given an m x n 2D binary grid board which represents a map of '1's (land) and '0's (water), 
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands 
 * horizontally or vertically.
 */
public class NumberOfIslands {

    /**
     * Solution: Depth-First Search (Optimal)
     * Strategy: Iterate through each cell. If it is land ('1'), increment island count 
     * and perform DFS to sink all connected land (turn '1's into '0's).
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N) - Recursion stack.
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0'; // sink the land
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }

    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("Islands: " + solver.numIslands(grid)); // 3
    }
}
