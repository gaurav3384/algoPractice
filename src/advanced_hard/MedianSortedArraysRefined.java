package advanced_hard;

/**
 * Problem: Median of Two Sorted Arrays (Optimal Refined)
 * Time Complexity: O(log(min(M, N)))
 * Space Complexity: O(1)
 */
public class MedianSortedArraysRefined {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;
        
        while (l <= r) {
            int px = (l + r) / 2;
            int py = (m + n + 1) / 2 - px;
            
            int lx = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
            int rx = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int ly = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];
            int ry = (py == n) ? Integer.MAX_VALUE : nums2[py];
            
            if (lx <= ry && ly <= rx) {
                if ((m + n) % 2 == 0) return (Math.max(lx, ly) + Math.min(rx, ry)) / 2.0;
                else return Math.max(lx, ly);
            } else if (lx > ry) r = px - 1;
            else l = px + 1;
        }
        return 0.0;
    }
}
