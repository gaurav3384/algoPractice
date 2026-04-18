package graphs;

import java.util.*;

/**
 * Problem: Course Schedule II
 * Concepts: Graph, Depth-First Search, Breadth-First Search, Topological Sort
 * 
 * Description:
 * Return the ordering of courses you should take to finish all courses. 
 * If there are many valid answers, return any of them. 
 * If it is impossible to finish all courses, return an empty array.
 */
public class CourseScheduleII {

    /**
     * Solution: Kahn's Algorithm (BFS-based Topological Sort)
     * Strategy:
     * 1. Calculate in-degree of all nodes.
     * 2. Add all nodes with in-degree 0 to a queue.
     * 3. Pop from queue, add to order, and decrement in-degree of neighbors.
     * 4. If neighbor in-degree becomes 0, add to queue.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            inDegree[p[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        
        int[] order = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[idx++] = u;
            for (int v : adj[u]) {
                if (--inDegree[v] == 0) queue.offer(v);
            }
        }
        
        return (idx == numCourses) ? order : new int[0];
    }

    public static void main(String[] args) {
        CourseScheduleII solver = new CourseScheduleII();
        int[][] pre = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println("Order: " + Arrays.toString(solver.findOrder(4, pre)));
    }
}
