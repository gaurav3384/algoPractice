package dynamic_programming_2d;

/**
 * Problem: Combination Sum IV
 * Concepts: Array, Dynamic Programming
 * 
 * Description:
 * Given an array of distinct integers nums and a target integer target, 
 * return the number of possible combinations that add up to target.
 * Note that different sequences are counted as different combinations.
 */
public class CombinationSumIV {

    /**
     * Solution: Iterative DP (Optimal)
     * Strategy: dp[i] stores the number of ways to reach sum i.
     * dp[i] = sum(dp[i - num]) for each num in nums.
     * 
     * Time Complexity: O(target * n)
     * Space Complexity: O(target)
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV solver = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        System.out.println("Total Ways for 4: " + solver.combinationSum4(nums, 4)); // 7
    }
}
