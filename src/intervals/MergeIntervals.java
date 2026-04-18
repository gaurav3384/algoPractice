package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Merge Intervals
 * Concepts: Array, Sorting
 * 
 * Description:
 * Given an array of intervals where intervals[i] = [starti, endi], merge all 
 * overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.
 */
public class MergeIntervals {

    /**
     * Solution: Sort and Merge (Optimal)
     * Strategy:
     * 1. Sort intervals by start time.
     * 2. Iterate through sorted intervals. 
     * 3. If current interval overlaps with the last added merged interval, update end time.
     * 4. Else, add current interval to the result list.
     * 
     * Time Complexity: O(N log N) - due to sorting.
     * Space Complexity: O(N) or O(log N) depending on sort implementation.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);
        
        for (int[] next : intervals) {
            if (next[0] <= current[1]) {
                // Overlap detected: update end time to the max of both
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap: move pointer to next and add to list
                current = next;
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals solver = new MergeIntervals();
        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        System.out.println("Merged: " + Arrays.deepToString(solver.merge(intervals)));
    }
}
