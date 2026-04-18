package dynamic_programming_1d;

/**
 * Problem: Partition Equal Subset Sum
 * Concepts: Array, Dynamic Programming
 * 
 * Description:
 * Given a non-empty array nums containing only positive integers, find if the array 
 * can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {

    /**
     * Solution: 0/1 Knapsack DP (Optimal)
     * Strategy: We need to find if there's a subset with sum = (totalSum / 2).
     * Use a boolean DP array where dp[i] is true if sum i is achievable.
     * 
     * Time Complexity: O(n * sum)
     * Space Complexity: O(sum)
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                if (dp[i - n]) {
                    dp[i] = true;
                }
            }
            if (dp[target]) return true;
        }
        
        return dp[target];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum solver = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can Partition: " + solver.canPartition(nums)); // true
    }
}
