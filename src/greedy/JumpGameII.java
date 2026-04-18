package greedy;

/**
 * Problem: Jump Game II
 * Concepts: Array, Greedy, Dynamic Programming
 * 
 * Description:
 * You are given a 0-indexed array of integers nums of length n. You are initially 
 * positioned at nums[0]. Return the minimum number of jumps to reach nums[n - 1].
 */
public class JumpGameII {

    /**
     * Solution: Greedy BFS-style (Optimal)
     * Strategy: Maintain the current range [left, right] reachable with 'jumps' steps.
     * Find the farthest point reachable from any index in the current range.
     * That farthest point becomes the 'right' bound for 'jumps + 1'.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII solver = new JumpGameII();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Min Jumps: " + solver.jump(nums)); // 2
    }
}
