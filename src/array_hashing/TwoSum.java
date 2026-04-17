package array_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Two Sum
 * Concepts: Array, Hash Table
 * 
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    /**
     * Solution 1: Brute Force
     * Strategy: Iterate through each element and check if there's another element that adds up to the target.
     * 
     * Time Complexity: O(n^2) - Two nested loops.
     * Space Complexity: O(1) - No extra space used.
     * 
     * Example: nums = [2,7,11,15], target = 9 -> Output: [0, 1]
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    /**
     * Solution 2: Two-Pass Hash Map (Improved)
     * Strategy: Use a Hash Map to store value-to-index mapping. In the first pass, we populate the map. 
     * In the second pass, we check if the complement (target - nums[i]) exists in the map.
     * 
     * Time Complexity: O(n) - Two iterations over the array.
     * Space Complexity: O(n) - Stores up to n elements in the Hash Map.
     * 
     * Example: nums = [3,2,4], target = 6 -> Output: [1, 2]
     */
    public int[] twoSumTwoPass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[] {};
    }

    /**
     * Solution 3: One-Pass Hash Map (Optimal)
     * Strategy: While iterating through the array, check if the complement already exists in the map.
     * If not, add the current value and index to the map.
     * 
     * Time Complexity: O(n) - One iteration over the array.
     * Space Complexity: O(n) - Stores up to n elements in the Hash Map.
     * 
     * Example: nums = [3,3], target = 6 -> Output: [0, 1]
     */
    public int[] twoSumOnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        TwoSum solver = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solver.twoSumOnePass(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
