package linked_list;

/**
 * Problem: Remove Nth Node From End of List
 * Concepts: Linked List, Two Pointers
 * 
 * Description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEnd {

    /**
     * Solution: Two Pointers (Optimal)
     * Strategy: Use two pointers 'first' and 'second'. 
     * Move 'first' n steps ahead. Then move both until 'first' reaches the end.
     * 'second' will be right before the node to be removed.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Advance first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // second.next is the node to be removed
        second.next = second.next.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd solver = new RemoveNthNodeFromEnd();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solver.removeNthFromEnd(head, 2);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
