package intervals;

import java.util.Arrays;

/**
 * Problem: Meeting Rooms
 * Concepts: Array, Sorting
 * 
 * Description:
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], 
 * determine if a person could attend all meetings.
 */
public class MeetingRooms {

    /**
     * Solution: Sorting (Optimal)
     * Strategy: Sort meetings by start time. Check if any meeting starts 
     * before the previous one ends.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1) or O(log N)
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms solver = new MeetingRooms();
        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        System.out.println("Can attend: " + solver.canAttendMeetings(intervals)); // false
    }
}
