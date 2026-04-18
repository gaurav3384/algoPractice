package heap_priority_queue;

import java.util.PriorityQueue;

/**
 * Problem: Kth Largest Element in an Array
 * Concepts: Array, Divide and Conquer, Sorting, Heap, Quickselect
 * 
 * Description:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestElement {

    /**
     * Solution 1: Min-Heap (Optimal for large streams)
     * Strategy: Use a Min-Heap of size k. Iterate through the array. 
     * If current element is larger than the root of heap, replace it. 
     * At the end, the root is the kth largest.
     * 
     * Time Complexity: O(n log k)
     * Space Complexity: O(k)
     * 
     * Example: nums = [3,2,3,1,2,4,5,5,6], k = 4 -> Output: 4
     */
    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /**
     * Solution 2: Quickselect (Optimal Average Case)
     * Strategy: Based on QuickSort partitioning. Partition the array around a pivot. 
     * If the pivot index is n-k, we found the kth largest.
     * 
     * Time Complexity: O(n) average, O(n^2) worst case.
     * Space Complexity: O(1)
     */
    public int findKthLargestQuickselect(int[] nums, int k) {
        return quickselect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        
        int pivotIndex = partition(nums, left, right);
        if (pivotIndex == k) {
            return nums[k];
        } else if (pivotIndex < k) {
            return quickselect(nums, pivotIndex + 1, right, k);
        } else {
            return quickselect(nums, left, pivotIndex - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement solver = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("4th Largest: " + solver.findKthLargestHeap(nums, 2)); // 5
    }
}
