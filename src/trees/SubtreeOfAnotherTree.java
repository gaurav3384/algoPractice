package trees;

/**
 * Problem: Subtree of Another Tree
 * Concepts: Tree, Depth-First Search, Recursion
 * 
 * Description:
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree 
 * of root with the same structure and node values of subRoot and false otherwise.
 */
public class SubtreeOfAnotherTree {

    /**
     * Solution: Recursive DFS (Optimal)
     * Strategy:
     * 1. Traverse the 'root' tree.
     * 2. For each node, check if the tree rooted at that node is identical to 'subRoot'.
     * 3. Identity check is done using 'isSameTree' (same logic as Problem 39).
     * 
     * Time Complexity: O(n * m) - Worst case we check subRoot at every node of root.
     * Space Complexity: O(n) - Recursion stack.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        
        if (isSameTree(root, subRoot)) return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solver = new SubtreeOfAnotherTree();
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println("Is Subtree: " + solver.isSubtree(root, subRoot));
    }
}
