package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Invert Binary Tree
 * Concepts: Tree, Recursion, Iteration
 * 
 * Description:
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {

    /**
     * Solution 1: Recursive DFS (Optimal)
     * Strategy: Swap left and right children recursively.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h) where h is height.
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) return null;
        
        TreeNode left = invertTreeRecursive(root.left);
        TreeNode right = invertTreeRecursive(root.right);
        
        root.left = right;
        root.right = left;
        
        return root;
    }

    /**
     * Solution 2: Iterative BFS
     * Strategy: Use a queue to swap children level by level.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // Swap
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree solver = new InvertBinaryTree();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode inverted = solver.invertTreeRecursive(root);
        System.out.println("Inverted Root Left: " + inverted.left.val); // Should be 7
    }
}
