package heap_priority_queue;

import java.util.*;

/**
 * Problem: Top K Frequent Elements
 * Concepts: Array, Hash Table, Sorting, Heap, Bucket Sort
 * 
 * Description:
 * Given an integer array nums and an integer k, return the k most frequent elements. 
 * You may return the answer in any order.
 */
public class TopKFrequentElements {

    /**
     * Solution 1: Max-Heap (Standard)
     * Strategy: Use a HashMap for frequency counts, then a Heap to extract the top k.
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(n)
     */
    public int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        for (int key : freq.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();
        return res;
    }

    /**
     * Solution 2: Bucket Sort (Optimal)
     * Strategy:
     * 1. Count frequencies using HashMap.
     * 2. Use buckets where bucket[i] stores elements with frequency i.
     * 3. Iterate backward from highest frequency to collect k elements.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] topKFrequentOptimal(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : nums) countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : countMap.keySet()) {
            int freq = countMap.get(key);
            if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
            buckets[freq].add(key);
        }
        
        int[] res = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[idx++] = num;
                    if (idx == k) break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElements solver = new TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("Top 2: " + Arrays.toString(solver.topKFrequentOptimal(nums, 2)));
    }
}
