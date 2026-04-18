package linked_list;

/**
 * Problem: Intersection of Two Linked Lists
 * Concepts: Linked List, Two Pointers
 * 
 * Description:
 * Given the heads of two singly linked-lists headA and headB, return the node 
 * at which the two lists intersect. If the two linked lists have no intersection 
 * at all, return null.
 */
public class IntersectionTwoLinkedLists {

    /**
     * Solution: Two Pointers (Optimal)
     * Strategy: Use two pointers, ptrA and ptrB. 
     * When ptrA reaches the end of list A, redirect it to headB.
     * When ptrB reaches the end of list B, redirect it to headA.
     * They will eventually meet at the intersection node or at null.
     * 
     * Time Complexity: O(M + N)
     * Space Complexity: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        while (ptrA != ptrB) {
            ptrA = (ptrA == null) ? headB : ptrA.next;
            ptrB = (ptrB == null) ? headA : ptrB.next;
        }
        
        return ptrA;
    }

    public static void main(String[] args) {
        IntersectionTwoLinkedLists solver = new IntersectionTwoLinkedLists();
        ListNode intersect = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, intersect));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, intersect)));
        
        ListNode result = solver.getIntersectionNode(headA, headB);
        System.out.println("Intersection at: " + (result != null ? result.val : "null"));
    }
}
