package binary_search;

/**
 * Problem: Median of Two Sorted Arrays
 * Concepts: Array, Binary Search, Divide and Conquer
 * 
 * Description:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, 
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

    /**
     * Solution: Binary Search on Partition (Optimal)
     * Strategy: Partition both arrays into two halves such that:
     * 1. Total elements in left half = Total elements in right half.
     * 2. Max(left_half) <= Min(right_half).
     * Binary search is performed on the smaller array to find the partition index.
     * 
     * Time Complexity: O(log(min(m, n)))
     * Space Complexity: O(1)
     * 
     * Example: nums1 = [1,3], nums2 = [2] -> Output: 2.0
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        
        while (left <= right) {
            int partitionX = left + (right - left) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solver = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println("Median: " + solver.findMedianSortedArrays(nums1, nums2));
    }
}
