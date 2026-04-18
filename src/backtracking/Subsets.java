package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Subsets
 * Concepts: Array, Backtracking
 * 
 * Description:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {

    /**
     * Solution: Backtracking (Optimal)
     * Strategy: For each element, we have two choices: include it in the current subset or not.
     * 
     * Time Complexity: O(N * 2^N) - 2^N subsets, each taking O(N) to copy.
     * Space Complexity: O(N) - Recursion stack.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> res) {
        res.add(new ArrayList<>(current));
        
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, res);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets solver = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println("Subsets: " + solver.subsets(nums));
    }
}
