package binary_search;

/**
 * Problem: Binary Search
 * Concepts: Array, Binary Search
 * 
 * Description:
 * Given an array of integers nums which is sorted in ascending order, and an integer target, 
 * write a function to search target in nums. If target exists, then return its index. 
 * Otherwise, return -1.
 */
public class BinarySearch {

    /**
     * Solution: Binary Search (Optimal)
     * Strategy: Use two pointers (left, right) to repeatedly divide the search space in half.
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * Example: nums = [-1,0,3,5,9,12], target = 9 -> Output: 4
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solver = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println("Index of 9: " + solver.search(nums, 9));
    }
}
