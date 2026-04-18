package heap_priority_queue;

import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * Problem: Merge k Sorted Lists
 * Concepts: Linked List, Divide and Conquer, Heap
 * 
 * Description:
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 */
public class MergeKSortedLists {

    /**
     * Solution: Min-Heap (Optimal)
     * Strategy: Use a Min-Heap to store the current head of each list.
     * 1. Add heads of all k lists to the Min-Heap.
     * 2. Extract the smallest node from the heap, add it to the merged list.
     * 3. Add the next node of the extracted node to the heap.
     * 
     * Time Complexity: O(N log k) where N is total nodes and k is number of lists.
     * Space Complexity: O(k) for the heap.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            
            if (node.next != null) {
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solver = new MergeKSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = {l1, l2, l3};
        
        ListNode result = solver.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
