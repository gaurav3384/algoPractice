package advanced_hard;

/**
 * Common Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * Problem: Reverse Nodes in k-Group
 * Concepts: Linked List, Recursion, Iteration
 * 
 * Description:
 * Given a linked list, reverse the nodes of a linked list k at a time and 
 * return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 */
public class ReverseKGroup {

    /**
     * Solution: Iterative Reverse with Sentinel (Optimal)
     * Strategy:
     * 1. Count the length of the list.
     * 2. For each group of k:
     *    - Reverse k nodes using three pointers (prev, curr, next).
     *    - Connect the reversed part to the previous group and the next group.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy, next = dummy, prev = dummy;
        int count = 0;
        
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        ReverseKGroup solver = new ReverseKGroup();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = solver.reverseKGroup(head, 2);
        
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        } // Output: 2 1 4 3 5
    }
}
