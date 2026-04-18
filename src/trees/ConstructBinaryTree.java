package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Construct Binary Tree from Preorder and Inorder Traversal
 * Concepts: Tree, Array, Hash Table, Divide and Conquer
 * 
 * Description:
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal 
 * of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 */
public class ConstructBinaryTree {

    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    /**
     * Solution: Recursive partitioning (Optimal)
     * Strategy:
     * 1. The first element of preorder is the root.
     * 2. Find the root's index in inorder to split the tree into left and right subtrees.
     * 3. Recursively build the subtrees.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Hash map and recursion stack.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTree solver = new ConstructBinaryTree();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = solver.buildTree(preorder, inorder);
        System.out.println("Root: " + root.val); // 3
    }
}
