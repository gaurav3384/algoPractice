package advanced_hard;

import java.util.Stack;

/**
 * Problem: Binary Search Tree Iterator
 * Concepts: Tree, Stack, Design, Iterator
 * 
 * Description:
 * Implement the BSTIterator class that represents an iterator over the in-order 
 * traversal of a binary search tree (BST).
 */
public class BSTIterator {

    private Stack<TreeNode> stack;

    /**
     * Solution: Controlled Recursion using Stack (Optimal)
     * Strategy: Push all left children of the current node to the stack. 
     * When 'next()' is called, pop a node and push all left children of its right child.
     * 
     * Time Complexity: O(1) average for next() and hasNext().
     * Space Complexity: O(h) where h is height.
     */
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        pushAllLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        } // 3 7 9 15 20
    }
}
