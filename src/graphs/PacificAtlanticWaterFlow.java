package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Pacific Atlantic Water Flow
 * Concepts: Array, Depth-First Search, Breadth-First Search, Matrix
 * 
 * Description:
 * Given an m x n matrix of heights, where heights[r][c] represents the height above sea level.
 * Rain water can flow to neighboring cells (up, down, left, right) if the height is less 
 * than or equal to the current cell's height. 
 * Return a list of coordinates where water can flow to both Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {

    /**
     * Solution: DFS from Oceans (Optimal)
     * Strategy: Instead of checking every cell, perform DFS starting from the oceans' 
     * edges and move inward to find all reachable cells.
     * 1. Traverse Pacific edges (top and left).
     * 2. Traverse Atlantic edges (bottom and right).
     * 3. Result is intersection of reachable cells for both oceans.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0) return res;
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Rows
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, n - 1, Integer.MIN_VALUE, atlantic);
        }
        // Columns
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, Integer.MIN_VALUE, pacific);
            dfs(heights, m - 1, j, Integer.MIN_VALUE, atlantic);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] h, int r, int c, int prevH, boolean[][] ocean) {
        if (r < 0 || r >= h.length || c < 0 || c >= h[0].length || 
            ocean[r][c] || h[r][c] < prevH) {
            return;
        }
        
        ocean[r][c] = true;
        dfs(h, r + 1, c, h[r][c], ocean);
        dfs(h, r - 1, c, h[r][c], ocean);
        dfs(h, r, c + 1, h[r][c], ocean);
        dfs(h, r, c - 1, h[r][c], ocean);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();
        int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}};
        System.out.println("Coordinates: " + solver.pacificAtlantic(heights));
    }
}
