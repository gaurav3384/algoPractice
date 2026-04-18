package dynamic_programming_1d;

import java.util.Arrays;

/**
 * Problem: Longest Increasing Subsequence
 * Concepts: Array, Binary Search, Dynamic Programming
 * 
 * Description:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */
public class LongestIncreasingSubsequence {

    /**
     * Solution 1: Iterative DP (Standard)
     * Strategy: dp[i] stores the length of LIS ending at index i.
     * dp[i] = max(dp[j] + 1) for all j < i such that nums[j] < nums[i].
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int lengthOfLISDP(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    /**
     * Solution 2: Binary Search / Patience Sorting (Optimal)
     * Strategy: Maintain an active subsequence. For each number, if it's larger 
     * than any in the sequence, append it. Otherwise, replace the smallest element 
     * that is greater than or equal to it using binary search.
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int lengthOfLISOptimal(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) i = m + 1;
                else j = m;
            }
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence solver = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("LIS Length: " + solver.lengthOfLISOptimal(nums)); // 4
    }
}
