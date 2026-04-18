package heap_priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem: Find Median from Data Stream
 * Concepts: Heap, Design, Sorting, Data Stream
 * 
 * Description:
 * Design a data structure that supports the following two operations:
 * - void addNum(int num) Add a integer number from the data stream to the data structure.
 * - double findMedian() Return the median of all elements so far.
 */
public class MedianFinder {

    private PriorityQueue<Integer> small; // Max-heap to store the smaller half
    private PriorityQueue<Integer> large; // Min-heap to store the larger half

    /**
     * Solution: Two Heaps (Optimal)
     * Strategy:
     * - 'small' max-heap stores the smaller half of numbers.
     * - 'large' min-heap stores the larger half of numbers.
     * - The difference in sizes is at most 1.
     * - Median is either the root of the larger heap or the average of both roots.
     * 
     * Time Complexity: O(log N) for addNum, O(1) for findMedian.
     * Space Complexity: O(N)
     */
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        
        // Move the largest of the small half to the large half
        large.offer(small.poll());
        
        // Balance sizes: small can have at most 1 more element than large
        if (small.size() < large.size()) {
            small.offer(large.poll());
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return (double) small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
    }
}
