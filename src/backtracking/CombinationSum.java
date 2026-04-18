package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Combination Sum
 * Concepts: Array, Backtracking
 * 
 * Description:
 * Given an array of distinct integers candidates and a target integer target, 
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. 
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 */
public class CombinationSum {

    /**
     * Solution: Backtracking (Optimal)
     * Strategy: Try including each candidate. Since we can reuse candidates, 
     * the next index in the recursion remains 'i'.
     * 
     * Time Complexity: O(2^T) where T is the target value.
     * Space Complexity: O(T/M) where M is minimal candidate value.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] candidates, int target, List<Integer> current, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Reuse same element by passing 'i' instead of 'i + 1'
            backtrack(i, candidates, target - candidates[i], current, res);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solver = new CombinationSum();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println("Combinations: " + solver.combinationSum(nums, target));
    }
}
