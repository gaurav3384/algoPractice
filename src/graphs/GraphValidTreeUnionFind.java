package graphs;

/**
 * Problem: Graph Valid Tree
 * Concepts: Graph, DFS, BFS, Union Find
 * 
 * Description:
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges, 
 * return true if these edges make up a valid tree.
 */
public class GraphValidTreeUnionFind {

    /**
     * Solution: Union Find (Optimal)
     * Strategy: 
     * 1. A tree must have exactly n - 1 edges.
     * 2. Use Union Find to detect cycles and check if all nodes are connected.
     * 
     * Time Complexity: O(V + E * alpha(V)) where alpha is inverse Ackermann.
     * Space Complexity: O(V)
     */
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] edge : edges) {
            int root1 = find(edge[0], parent);
            int root2 = find(edge[1], parent);
            
            if (root1 == root2) return false; // Cycle detected
            parent[root1] = root2;
        }
        
        return true;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }

    public static void main(String[] args) {
        GraphValidTreeUnionFind solver = new GraphValidTreeUnionFind();
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        System.out.println("Is Valid Tree: " + solver.validTree(5, edges)); // true
    }
}
