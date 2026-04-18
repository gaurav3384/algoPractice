package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Permutations
 * Concepts: Array, Backtracking
 * 
 * Description:
 * Given an array nums of distinct integers, return all the possible permutations. 
 * You can return the answer in any order.
 */
public class Permutations {

    /**
     * Solution: Backtracking (Optimal)
     * Strategy: Swap elements to build permutations in-place, then restore.
     * 
     * Time Complexity: O(N * N!)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> current = new ArrayList<>();
            for (int n : nums) current.add(n);
            res.add(current);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(start + 1, nums, res);
            swap(nums, start, i); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println("Permutations: " + solver.permute(nums));
    }
}
