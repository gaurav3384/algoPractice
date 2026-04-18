package linked_list;

/**
 * Problem: Add Two Numbers
 * Concepts: Linked List, Math
 * 
 * Description:
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 */
public class AddTwoNumbers {

    /**
     * Solution: Single Pass with Carry (Optimal)
     * Strategy: Iterate through both lists simultaneously. 
     * Keep track of a carry variable. Sum the values and the carry at each step.
     * 
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n)) - Output list.
     * 
     * Example: l1 = [2,4,3], l2 = [5,6,4] -> Output: [7,0,8] (342 + 465 = 807)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers solver = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode result = solver.addTwoNumbers(l1, l2);
        
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
