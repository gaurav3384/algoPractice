package array_hashing;

/**
 * Problem: Search in Rotated Sorted Array
 * Concepts: Array, Binary Search
 * 
 * Description:
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index.
 * Given the array nums after the possible rotation and an integer target, 
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInRotatedSortedArray {

    /**
     * Solution: Modified Binary Search (Optimal)
     * Strategy: At every step, at least one half of the current range [left, right] must be sorted.
     * We check which half is sorted and then determine if the target lies within its bounds.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * Example: nums = [4,5,6,7,0,1,2], target = 0 -> Output: 4
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) return mid;
            
            // Identify which half is sorted
            if (nums[left] <= nums[mid]) {
                // Left half [left...mid] is sorted
                if (target >= nums[left] && target < nums[mid]) {
                    // Target is in the sorted left half
                    right = mid - 1;
                } else {
                    // Target must be in the right half
                    left = mid + 1;
                }
            } else {
                // Right half [mid...right] is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    // Target is in the sorted right half
                    left = mid + 1;
                } else {
                    // Target must be in the left half
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solver = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of " + target + ": " + solver.search(nums, target));
    }
}
