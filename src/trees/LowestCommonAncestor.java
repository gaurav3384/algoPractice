package trees;

/**
 * Problem: Lowest Common Ancestor of a Binary Tree
 * Concepts: Tree, Depth-First Search, Recursion
 * 
 * Description:
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * LCA is the lowest node in T that has both p and q as descendants.
 */
public class LowestCommonAncestor {

    /**
     * Solution: Recursive DFS (Optimal)
     * Strategy:
     * 1. If root is null or matches p or q, return root.
     * 2. Recurse for left and right children.
     * 3. If both left and right results are non-null, the current root is the LCA.
     * 4. Otherwise, return the non-null child result.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor solver = new LowestCommonAncestor();
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode root = new TreeNode(3, p, q);
        System.out.println("LCA: " + solver.lowestCommonAncestor(root, p, q).val); // 3
    }
}
