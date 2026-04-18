package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Rotting Oranges
 * Concepts: Array, Breadth-First Search, Matrix
 * 
 * Description:
 * You are given an m x n grid where each cell can have one of three values:
 * 0 (empty), 1 (fresh orange), or 2 (rotten orange).
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten 
 * orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
 * If this is impossible, return -1.
 */
public class RottingOranges {

    /**
     * Solution: Multi-source BFS (Optimal)
     * Strategy:
     * 1. Add all initial rotten oranges to a queue. Count fresh oranges.
     * 2. Perform BFS level by level. Each level represents 1 minute.
     * 3. For each rotten orange, infect its fresh neighbors and decrement fresh count.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M * N)
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) freshCount++;
            }
        }
        
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectedThisMinute = false;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dirs) {
                    int ni = curr[0] + d[0];
                    int nj = curr[1] + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        queue.offer(new int[]{ni, nj});
                        freshCount--;
                        infectedThisMinute = true;
                    }
                }
            }
            if (infectedThisMinute) minutes++;
        }
        
        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges solver = new RottingOranges();
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        System.out.println("Minutes: " + solver.orangesRotting(grid)); // 4
    }
}
