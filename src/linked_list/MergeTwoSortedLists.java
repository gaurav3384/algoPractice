package linked_list;

/**
 * Problem: Merge Two Sorted Lists
 * Concepts: Linked List, Recursion, Iteration
 * 
 * Description:
 * Merge two sorted linked lists and return it as a new sorted list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {

    /**
     * Solution 1: Iterative (Optimal Space)
     * Strategy: Use a dummy node and a current pointer to build the new list.
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        
        // Append remaining nodes
        curr.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }

    /**
     * Solution 2: Recursive
     * Strategy: Recursively choose the smaller node and merge the rest.
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m) - Stack space.
     */
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solver = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = solver.mergeTwoListsIterative(l1, l2);
        
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
