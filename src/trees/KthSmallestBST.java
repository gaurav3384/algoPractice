package trees;

import java.util.Stack;

/**
 * Problem: Kth Smallest Element in a BST
 * Concepts: Tree, Binary Search Tree, In-order Traversal
 * 
 * Description:
 * Given the root of a binary search tree, and an integer k, 
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestBST {

    /**
     * Solution 1: Iterative In-order Traversal (Optimal)
     * Strategy: In-order traversal of a BST yields values in ascending order.
     * Use a stack to perform traversal and stop at the kth element.
     * 
     * Time Complexity: O(h + k) where h is tree height.
     * Space Complexity: O(h)
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        KthSmallestBST solver = new KthSmallestBST();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println("2nd Smallest: " + solver.kthSmallest(root, 2)); // 2
    }
}
