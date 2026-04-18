package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a Node.
 */
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

/**
 * Problem: Clone Graph
 * Concepts: Hash Table, Depth-First Search, Breadth-First Search, Graph
 * 
 * Description:
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 */
public class CloneGraph {

    /**
     * Solution: Recursive DFS (Optimal)
     * Strategy: Use a map to store original-to-clone mapping to handle cycles 
     * and avoid infinite recursion.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        
        Node clone = new Node(node.val);
        visited.put(node, clone);
        
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        
        return clone;
    }
}
