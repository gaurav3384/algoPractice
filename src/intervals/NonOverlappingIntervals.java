package intervals;

import java.util.Arrays;

/**
 * Problem: Non-overlapping Intervals
 * Concepts: Array, Greedy, Sorting
 * 
 * Description:
 * Given an array of intervals intervals where intervals[i] = [starti, endi], 
 * return the minimum number of intervals you need to remove to make the rest 
 * of the intervals non-overlapping.
 */
public class NonOverlappingIntervals {

    /**
     * Solution: Greedy by End Time (Optimal)
     * Strategy:
     * 1. Sort intervals by their end times.
     * 2. Always pick the interval that ends earliest to leave more room for others.
     * 3. Count how many intervals can be kept.
     * 4. Result = Total Intervals - Kept Intervals.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1) or O(log N)
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 1; // Number of non-overlapping intervals kept
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // No overlap
                count++;
                end = intervals[i][1];
            }
        }
        
        return intervals.length - count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solver = new NonOverlappingIntervals();
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println("Removed: " + solver.eraseOverlapIntervals(intervals)); // 1
    }
}
