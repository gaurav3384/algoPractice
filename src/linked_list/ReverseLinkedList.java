package linked_list;

/**
 * Common Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * Problem: Reverse Linked List
 * Concepts: Linked List, Recursion, Iteration
 * 
 * Description:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    /**
     * Solution 1: Iterative (Optimal)
     * Strategy: Iterate through the list, changing the next pointer of each node to its previous node.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        return prev;
    }

    /**
     * Solution 2: Recursive
     * Strategy: Reverse the rest of the list and then adjust the pointers for the current node.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) - Implicit stack due to recursion.
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode reversed = solver.reverseListIterative(head);
        
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
