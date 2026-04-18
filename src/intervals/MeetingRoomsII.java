package intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Problem: Meeting Rooms II
 * Concepts: Array, Greedy, Sorting, Heap
 * 
 * Description:
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], 
 * return the minimum number of conference rooms required.
 */
public class MeetingRoomsII {

    /**
     * Solution 1: Priority Queue (Optimal)
     * Strategy:
     * 1. Sort meetings by start time.
     * 2. Use a Min-Heap to store the end times of ongoing meetings.
     * 3. For each meeting, if its start time is >= earliest end time in heap, 
     *    reuse that room (pop from heap).
     * 4. Add current meeting's end time to heap.
     * 5. Size of heap is the number of rooms needed.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= heap.peek()) {
                heap.poll(); // Room is free, reuse it
            }
            heap.offer(intervals[i][1]);
        }
        
        return heap.size();
    }

    /**
     * Solution 2: Chronological Ordering
     * Strategy: Sort start times and end times separately.
     * Use two pointers to track how many meetings have started vs ended.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int minMeetingRoomsChronological(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0, endPtr = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII solver = new MeetingRoomsII();
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        System.out.println("Rooms: " + solver.minMeetingRooms(intervals)); // 2
    }
}
