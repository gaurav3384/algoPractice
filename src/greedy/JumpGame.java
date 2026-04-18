package greedy;

/**
 * Problem: Jump Game
 * Concepts: Array, Greedy, Dynamic Programming
 * 
 * Description:
 * You are given an integer array nums. You are initially positioned at the array's 
 * first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {

    /**
     * Solution: Greedy Goal Post (Optimal)
     * Strategy: Work backwards. Start with the goal at the last index. 
     * If an earlier index can reach the current goal, move the goal to that earlier index.
     * At the end, check if the goal reached index 0.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        
        return goal == 0;
    }

    public static void main(String[] args) {
        JumpGame solver = new JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("Can Reach: " + solver.canJump(nums)); // true
    }
}
