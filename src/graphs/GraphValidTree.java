package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Graph Valid Tree
 * Concepts: Graph, DFS, BFS, Union Find
 * 
 * Description:
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges, 
 * write a function to check whether these edges make up a valid tree.
 */
public class GraphValidTree {

    /**
     * Solution 1: DFS Cycle Detection (Optimal)
     * Strategy: A tree is a connected graph with no cycles.
     * For undirected graphs:
     * 1. Check if number of edges is n - 1.
     * 2. Check if all nodes are reachable from node 0.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public boolean validTreeDFS(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        boolean[] visited = new boolean[n];
        if (hasCycle(0, -1, adj, visited)) return false;
        
        for (boolean v : visited) if (!v) return false;
        
        return true;
    }

    private boolean hasCycle(int u, int p, List<Integer>[] adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (v == p) continue;
            if (visited[v] || hasCycle(v, u, adj, visited)) return true;
        }
        return false;
    }

    /**
     * Solution 2: Union Find
     * Strategy: Iterate through edges and union nodes. 
     * If two nodes already belong to same set, a cycle is detected.
     */
    public boolean validTreeUnionFind(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] e : edges) {
            int root1 = find(e[0], parent);
            int root2 = find(e[1], parent);
            if (root1 == root2) return false; // cycle
            parent[root1] = root2;
        }
        return true;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }

    public static void main(String[] args) {
        GraphValidTree solver = new GraphValidTree();
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println("Is Valid Tree: " + solver.validTreeUnionFind(5, edges)); // true
    }
}
