package trees;

/**
 * Problem: Same Tree
 * Concepts: Tree, Depth-First Search, Recursion
 * 
 * Description:
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, 
 * and the nodes have the same value.
 */
public class SameTree {

    /**
     * Solution: Recursive DFS (Optimal)
     * Strategy:
     * 1. If both are null, they are the same.
     * 2. If one is null or values differ, they are not the same.
     * 3. Recursively check left and right subtrees.
     * 
     * Time Complexity: O(min(n, m))
     * Space Complexity: O(min(h1, h2)) - h is height.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree solver = new SameTree();
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Is Same: " + solver.isSameTree(t1, t2));
    }
}
