package trees;

/**
 * Problem: Validate Binary Search Tree
 * Concepts: Tree, Depth-First Search, Recursion
 * 
 * Description:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 */
public class ValidateBinarySearchTree {

    /**
     * Solution: Recursive DFS with Range (Optimal)
     * Strategy: A node is valid if it is within a specific range (min, max).
     * 1. Left child must be within (min, root.val).
     * 2. Right child must be within (root.val, max).
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree solver = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Is Valid BST: " + solver.isValidBST(root));
    }
}
