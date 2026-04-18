package dynamic_programming_1d;

/**
 * Problem: House Robber
 * Concepts: Array, Dynamic Programming
 * 
 * Description:
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping 
 * you from robbing each of them is that adjacent houses have security systems connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    /**
     * Solution: Iterative DP with Space Optimization (Optimal)
     * Strategy: For each house i, you have two choices:
     * 1. Rob house i: Total = current_val + maxRob(i-2)
     * 2. Skip house i: Total = maxRob(i-1)
     * rob(i) = max(rob(i-1), rob(i-2) + nums[i])
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int prev2 = 0;
        int prev1 = 0;
        
        for (int num : nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber solver = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Max Money: " + solver.rob(nums)); // 12
    }
}
