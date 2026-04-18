package graphs;

/**
 * Problem: Max Area of Island
 * Concepts: Array, Depth-First Search, Breadth-First Search, Union Find
 * 
 * Description:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) 
 * connected 4-directionally (horizontal or vertical). 
 * The area of an island is the number of cells with value 1 in the island.
 * Return the maximum area of an island in grid.
 */
public class MaxAreaOfIsland {

    /**
     * Solution: Recursive DFS (Optimal)
     * Strategy: For each '1', trigger DFS to calculate the size of the island 
     * and sink it to avoid double counting.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        
        grid[r][c] = 0; // sink
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) + dfs(grid, r, c - 1);
    }

    public static void main(String[] args) {
        MaxAreaOfIsland solver = new MaxAreaOfIsland();
        int[][] grid = {{0,0,1,0,0}, {0,1,1,0,1}, {0,1,0,0,1}};
        System.out.println("Max Area: " + solver.maxAreaOfIsland(grid)); // 3
    }
}
