package graphs;

/**
 * Problem: Number of Connected Components in an Undirected Graph
 * Concepts: Graph, Union Find
 */
public class ConnectedComponentsOptimal {

    /**
     * Solution: Union Find (Optimal)
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        int count = n;
        for (int[] e : edges) {
            int r1 = find(e[0], parent);
            int r2 = find(e[1], parent);
            if (r1 != r2) {
                parent[r1] = r2;
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
        ConnectedComponentsOptimal solver = new ConnectedComponentsOptimal();
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        System.out.println("Result: " + solver.countComponents(5, edges)); // 2
    }
}
