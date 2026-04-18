package heap_priority_queue;

import java.util.Arrays;

/**
 * Problem: Task Scheduler
 * Concepts: Array, Hash Table, Greedy, Heap, Counting
 * 
 * Description:
 * Given a characters array tasks, representing the tasks a CPU needs to do, 
 * and an integer n, the cooling period between same tasks. 
 * Return the minimum number of units of times that the CPU will take to finish all the given tasks.
 */
public class TaskScheduler {

    /**
     * Solution: Greedy Frequency Calculation (Optimal)
     * Strategy: 
     * 1. Count frequency of each task.
     * 2. The most frequent task determines the minimum length.
     * 3. Let 'maxFreq' be the maximum frequency.
     * 4. Minimum units = (maxFreq - 1) * (n + 1) + (number of tasks with maxFreq).
     * 5. Result is max(tasks.length, minimum units).
     * 
     * Time Complexity: O(T) where T is number of tasks.
     * Space Complexity: O(1) - Constant size frequency array (26).
     * 
     * Example: tasks = ["A","A","A","B","B","B"], n = 2 -> Output: 8 (A -> B -> idle -> A -> B -> idle -> A -> B)
     */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;
        
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * n;
        
        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }
        
        idleTime = Math.max(0, idleTime);
        
        return tasks.length + idleTime;
    }

    public static void main(String[] args) {
        TaskScheduler solver = new TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println("Min Units: " + solver.leastInterval(tasks, 2));
    }
}
