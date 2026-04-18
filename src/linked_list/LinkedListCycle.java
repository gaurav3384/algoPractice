package linked_list;

/**
 * Problem: Linked List Cycle
 * Concepts: Linked List, Two Pointers, Hash Table
 * 
 * Description:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 */
public class LinkedListCycle {

    /**
     * Solution: Floyd's Cycle-Finding Algorithm (Optimal)
     * Strategy: Use two pointers, slow and fast. 
     * Move slow by 1 step and fast by 2 steps.
     * If there is a cycle, the fast pointer will eventually meet the slow pointer.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solver = new LinkedListCycle();
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        node2.next = new ListNode(0);
        node2.next.next = new ListNode(-4);
        node2.next.next.next = node2; // Create a cycle
        
        System.out.println("Has Cycle: " + solver.hasCycle(head));
    }
}
