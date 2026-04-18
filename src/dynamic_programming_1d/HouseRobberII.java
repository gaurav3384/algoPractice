package dynamic_programming_1d;

/**
 * Problem: House Robber II
 * Concepts: Array, Dynamic Programming
 * 
 * Description:
 * All houses at this place are arranged in a circle. That means the first house 
 * is the neighbor of the last one. 
 * Return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {

    /**
     * Solution: Two-Pass DP (Optimal)
     * Strategy: Since house 1 and house n are connected, we can either:
     * 1. Rob house 1 to n-1 (exclude house n).
     * 2. Rob house 2 to n (exclude house 1).
     * The result is the maximum of these two linear house-robber solutions.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        return Math.max(robLinear(nums, 0, nums.length - 2), 
                        robLinear(nums, 1, nums.length - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobberII solver = new HouseRobberII();
        int[] nums = {2, 3, 2};
        System.out.println("Max Rob: " + solver.rob(nums)); // 3
    }
}
