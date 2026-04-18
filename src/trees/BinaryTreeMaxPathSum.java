package trees;

/**
 * Problem: Binary Tree Maximum Path Sum
 * Concepts: Tree, Depth-First Search, Recursion
 * 
 * Description:
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes 
 * has an edge connecting them. A node can only appear in the sequence at most once. 
 * Return the maximum path sum of any non-empty path.
 */
public class BinaryTreeMaxPathSum {

    private int maxSum;

    /**
     * Solution: Post-order DFS (Optimal)
     * Strategy: For each node, calculate the maximum contribution it can make to a path 
     * through its parent (max(left, right) + val). 
     * Simultaneously, update the global maxSum by considering a path that branches 
     * at the current node (left + right + val).
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(h)
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromNode(root);
        return maxSum;
    }

    private int gainFromNode(TreeNode node) {
        if (node == null) return 0;

        // Recursively find max gain from left and right subtrees. 
        // If gain is negative, we ignore it (take 0).
        int leftGain = Math.max(gainFromNode(node.left), 0);
        int rightGain = Math.max(gainFromNode(node.right), 0);

        // Path sum including the current node as the highest point (branching point)
        int currentPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain this node can contribute to a path through its parent
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum solver = new BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Max Path Sum: " + solver.maxPathSum(root)); // Output: 42
    }
}
