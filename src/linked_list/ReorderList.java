package linked_list;

/**
 * Problem: Reorder List
 * Concepts: Linked List, Two Pointers, Reversal
 * 
 * Description:
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 */
public class ReorderList {

    /**
     * Solution: Find Mid, Reverse, and Merge (Optimal)
     * Strategy:
     * 1. Find the middle of the list using slow/fast pointers.
     * 2. Reverse the second half of the list.
     * 3. Interleave the first and second halves.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // 1. Find the middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse second half
        ListNode prev = null, curr = slow.next;
        slow.next = null; // Break the list
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        
        // 3. Merge two halves
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            first.next = second;
            second.next = tmp1;
            
            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        ReorderList solver = new ReorderList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solver.reorderList(head);
        
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
