package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: Binary Tree Level Order Traversal
 * Concepts: Tree, Breadth-First Search
 * 
 * Description:
 * Given the root of a binary tree, return the level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrder {

    /**
     * Solution: Iterative BFS (Optimal)
     * Strategy: Use a queue to store nodes level by level. 
     * For each level, capture all current nodes before adding their children.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Result storage and queue size.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrder solver = new BinaryTreeLevelOrder();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Level Order: " + solver.levelOrder(root));
    }
}
