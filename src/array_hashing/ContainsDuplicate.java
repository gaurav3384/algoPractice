package array_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Contains Duplicate
 * Concepts: Array, Hash Table, Sorting
 * 
 * Description:
 * Given an integer array nums, return true if any value appears at least twice in the array, 
 * and return false if every element is distinct.
 */
public class ContainsDuplicate {

    /**
     * Solution 1: Brute Force
     * Strategy: Compare every pair of elements in the array.
     * 
     * Time Complexity: O(n^2) - Nested loops.
     * Space Complexity: O(1) - No extra space.
     * 
     * Example: nums = [1,2,3,1] -> Output: true
     */
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    /**
     * Solution 2: Sorting
     * Strategy: Sort the array and check if any adjacent elements are the same.
     * 
     * Time Complexity: O(n log n) - Sorting takes O(n log n).
     * Space Complexity: O(1) or O(n) - Depending on the sorting algorithm.
     * 
     * Example: nums = [1,2,3,4] -> Output: false
     */
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    /**
     * Solution 3: Hash Set (Optimal)
     * Strategy: Use a Hash Set to store seen elements. If an element is already in the set, a duplicate exists.
     * 
     * Time Complexity: O(n) - One pass through the array.
     * Space Complexity: O(n) - Stores up to n elements in the Hash Set.
     * 
     * Example: nums = [1,1,1,3,3,4,3,2,4,2] -> Output: true
     */
    public boolean containsDuplicateOptimal(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        System.out.println("Contains Duplicate: " + solver.containsDuplicateOptimal(nums));
    }
}
