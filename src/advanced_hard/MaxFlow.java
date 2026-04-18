package advanced_hard;

import java.util.*;

/**
 * Problem: Maximum Flow (Not on LeetCode)
 * Concepts: Graph, BFS, Edmonds-Karp, Flow Network
 * 
 * Description:
 * Given a flow network with a source s and a sink t, find the maximum flow 
 * that can be sent from s to t.
 */
public class MaxFlow {

    /**
     * Solution: Edmonds-Karp Algorithm (BFS-based Ford-Fulkerson)
     * Strategy:
     * 1. Repeatedly find an augmenting path from source to sink using BFS.
     * 2. Calculate the bottleneck capacity of the path.
     * 3. Update residual capacities of edges and reverse edges.
     * 
     * Time Complexity: O(V * E^2)
     * Space Complexity: O(V^2) or O(V + E) depending on storage.
     */
    public int edmondsKarp(int[][] capacity, int s, int t) {
        int n = capacity.length;
        int[][] residual = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) residual[i][j] = capacity[i][j];
        }
        
        int[] parent = new int[n];
        int maxFlow = 0;
        
        while (bfs(residual, s, t, parent)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residual[u][v]);
            }
            
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                residual[u][v] -= pathFlow;
                residual[v][u] += pathFlow;
            }
            
            maxFlow += pathFlow;
        }
        
        return maxFlow;
    }

    private boolean bfs(int[][] r, int s, int t, int[] parent) {
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[r.length];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(s);
        visited[s] = true;
        
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < r.length; v++) {
                if (!visited[v] && r[u][v] > 0) {
                    parent[v] = u;
                    visited[v] = true;
                    q.offer(v);
                    if (v == t) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MaxFlow solver = new MaxFlow();
        int[][] capacity = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };
        System.out.println("Max Flow: " + solver.edmondsKarp(capacity, 0, 5)); // 23
    }
}
