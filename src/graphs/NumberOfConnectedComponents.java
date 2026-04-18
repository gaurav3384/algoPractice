package graphs;

/**
 * Problem: Number of Connected Components in an Undirected Graph
 * Concepts: Graph, DFS, BFS, Union Find
 * 
 * Description:
 * Given n nodes and a list of undirected edges, return the number of 
 * connected components in the graph.
 */
public class NumberOfConnectedComponents {

    /**
     * Solution: Union Find (Optimal)
     * Strategy: 
     * 1. Start with n components.
     * 2. For each edge, if the two nodes are in different sets, union them 
     *    and decrement the component count.
     * 
     * Time Complexity: O(V + E * alpha(V))
     * Space Complexity: O(V)
     */
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int count = n;
        for (int[] edge : edges) {
            int root1 = find(edge[0], parent);
            int root2 = find(edge[1], parent);
            
            if (root1 != root2) {
                parent[root1] = root2;
                count--;
            }
        }
        
        return count;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i], parent);
    }

    public static void main(String[] args) {
        NumberOfConnectedComponents solver = new NumberOfConnectedComponents();
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        System.out.println("Components: " + solver.countComponents(5, edges)); // 2
    }
}
