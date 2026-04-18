package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Common Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Problem: Maximum Depth of Binary Tree
 * Concepts: Tree, Depth-First Search, Breadth-First Search
 * 
 * Description:
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 */
public class MaximumDepthBinaryTree {

    /**
     * Solution 1: Recursive DFS (Optimal)
     * Strategy: Depth = 1 + max(depth(left), depth(right)).
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Worst case (skewed tree), O(log n) - Best case.
     */
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    /**
     * Solution 2: Iterative BFS
     * Strategy: Use a queue to process level by level.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Width of the tree.
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthBinaryTree solver = new MaximumDepthBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Max Depth: " + solver.maxDepthRecursive(root));
    }
}
