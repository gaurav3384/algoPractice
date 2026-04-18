package greedy;

/**
 * Problem: Jump Game
 * Concepts: Greedy, DP
 */
public class JumpGameOptimal {

    /**
     * Solution: Greedy Goal Tracking (Optimal)
     * Strategy: Work backwards from the last index. 
     * Move goal to current index if current index can reach the goal.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }

    public static void main(String[] args) {
        JumpGameOptimal solver = new JumpGameOptimal();
        System.out.println("Can jump: " + solver.canJump(new int[]{2,3,1,1,4}));
    }
}
