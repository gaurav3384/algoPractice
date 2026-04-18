package dynamic_programming_1d;

/**
 * Problem: Climbing Stairs
 * Concepts: Dynamic Programming, Fibonacci
 * 
 * Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: To reach step n, you could have come from step n-1 or n-2.
     * ways(n) = ways(n-1) + ways(n-2). This is the Fibonacci sequence.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int first = 1;
        int second = 2;
        
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs solver = new ClimbingStairs();
        System.out.println("Ways for 5 steps: " + solver.climbStairs(5)); // 8
    }
}
