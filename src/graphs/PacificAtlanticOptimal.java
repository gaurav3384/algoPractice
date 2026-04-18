package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Pacific Atlantic Water Flow
 * Concepts: Graph, DFS, Matrix
 */
public class PacificAtlanticOptimal {

    /**
     * Solution: DFS from Oceans (Optimal)
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, heights[i][0], pac);
            dfs(heights, i, n - 1, heights[i][n - 1], atl);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, heights[0][j], pac);
            dfs(heights, m - 1, j, heights[m - 1][j], atl);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void dfs(int[][] h, int r, int c, int prevH, boolean[][] ocean) {
        if (r < 0 || r >= h.length || c < 0 || c >= h[0].length || ocean[r][c] || h[r][c] < prevH) return;
        ocean[r][c] = true;
        dfs(h, r + 1, c, h[r][c], ocean);
        dfs(h, r - 1, c, h[r][c], ocean);
        dfs(h, r, c + 1, h[r][c], ocean);
        dfs(h, r, c - 1, h[r][c], ocean);
    }

    public static void main(String[] args) {
        PacificAtlanticOptimal solver = new PacificAtlanticOptimal();
        int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}};
        System.out.println("Result: " + solver.pacificAtlantic(heights));
    }
}
