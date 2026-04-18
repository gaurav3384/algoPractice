package array_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 3Sum
 * Concepts: Array, Two Pointers, Sorting
 * 
 * Description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    /**
     * Solution: Two Pointer with Sorting (Optimal)
     * Strategy: Sort the array. Iterate through each element i. 
     * For each i, use two pointers (left and right) to find pairs that sum to -nums[i].
     * Handle duplicates by skipping identical values for i, left, and right.
     * 
     * Time Complexity: O(n^2) - O(n log n) for sorting + O(n^2) for the nested loops.
     * Space Complexity: O(1) or O(n) - Depending on sorting implementation and output storage.
     * 
     * Example: nums = [-1,0,1,2,-1,-4] -> Output: [[-1,-1,2],[-1,0,1]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets: " + solver.threeSum(nums));
    }
}
