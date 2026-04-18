package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Course Schedule
 * Concepts: Graph, Depth-First Search, Breadth-First Search, Topological Sort
 * 
 * Description:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that 
 * you must take course bi first if you want to take course ai.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    /**
     * Solution: Cycle Detection in Directed Graph (Optimal)
     * Strategy: Represent courses as a directed graph. 
     * If there is a cycle, it's impossible to finish all courses.
     * Use DFS with state: 0 (unvisited), 1 (visiting), 2 (visited).
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V + E)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        for (int[] p : prerequisites) adj[p[1]].add(p[0]);
        
        int[] state = new int[numCourses]; // 0=new, 1=visiting, 2=done
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, state)) return false;
        }
        return true;
    }

    private boolean hasCycle(int u, List<Integer>[] adj, int[] state) {
        if (state[u] == 1) return true; // Cycle detected
        if (state[u] == 2) return false;
        
        state[u] = 1;
        for (int v : adj[u]) {
            if (hasCycle(v, adj, state)) return true;
        }
        state[u] = 2;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule solver = new CourseSchedule();
        int[][] pre = {{1,0}, {0,1}};
        System.out.println("Can Finish: " + solver.canFinish(2, pre)); // false
    }
}
