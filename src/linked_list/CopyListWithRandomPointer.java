package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a Node.
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * Problem: Copy List with Random Pointer
 * Concepts: Hash Table, Linked List
 * 
 * Description:
 * A linked list of length n is given such that each node contains an additional random pointer, 
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list.
 */
public class CopyListWithRandomPointer {

    /**
     * Solution 1: Hash Map (Simple)
     * Strategy: Use a map to store the mapping from original node to its copy.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public Node copyRandomListMap(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        
        return map.get(head);
    }

    /**
     * Solution 2: Interweaving (Optimal Space)
     * Strategy:
     * 1. Create copy of each node and insert it next to the original node.
     * 2. Set random pointers for copies.
     * 3. Separate the original and copy lists.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1) - No extra space besides the copy list.
     */
    public Node copyRandomListOptimal(Node head) {
        if (head == null) return null;
        
        // 1. Interweave
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            curr = next;
        }
        
        // 2. Set random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // 3. Separate lists
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;
        while (curr != null) {
            Node next = curr.next.next;
            Node copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copy;
            curr.next = next;
            curr = next;
        }
        
        return dummy.next;
    }
}
