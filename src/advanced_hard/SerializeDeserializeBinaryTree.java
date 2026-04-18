package advanced_hard;

import java.util.*;

/**
 * Problem: Serialize and Deserialize Binary Tree
 * Concepts: Tree, Breadth-First Search, Design
 * 
 * Description:
 * Serialization is the process of converting a data structure or object into a 
 * sequence of bits so that it can be stored in a file or memory buffer.
 * Design an algorithm to serialize and deserialize a binary tree.
 */
public class SerializeDeserializeBinaryTree {

    /**
     * Solution: BFS Serialization (Optimal)
     * Strategy:
     * - Serialize: Level-order traversal using a Queue. Use "null" for missing nodes.
     * - Deserialize: Reconstruct level by level using a Queue.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
                continue;
            }
            sb.append(node.val).append(",");
            q.offer(node.left);
            q.offer(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        for (int i = 1; i < vals.length; i++) {
            TreeNode parent = q.poll();
            if (!vals[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                parent.left = left;
                q.offer(left);
            }
            if (!vals[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String s = codec.serialize(root);
        System.out.println("Serialized: " + s);
        TreeNode d = codec.deserialize(s);
        System.out.println("Deserialized Root: " + d.val);
    }
}

/**
 * Node definition for Tree.
 */
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
    TreeNode(int x, TreeNode l, TreeNode r) { val = x; left = l; right = r; }
}
