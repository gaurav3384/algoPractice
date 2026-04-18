package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: Insert Interval
 * Concepts: Array
 * 
 * Description:
 * You are given an array of non-overlapping intervals sorted by their start time.
 * Insert a new interval into the intervals (merge if necessary).
 */
public class InsertInterval {

    /**
     * Solution: Linear Scan (Optimal)
     * Strategy:
     * 1. Add all intervals that end before the new interval starts.
     * 2. Merge the new interval with all overlapping intervals.
     * 3. Add all remaining intervals.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        
        // 1. Add all before
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        
        // 2. Merge overlapping
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        
        // 3. Add all after
        while (i < n) {
            res.add(intervals[i++]);
        }
        
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval solver = new InsertInterval();
        int[][] intervals = {{1,3}, {6,9}};
        int[] newInterval = {2,5};
        System.out.println("Result: " + Arrays.deepToString(solver.insert(intervals, newInterval)));
    }
}
