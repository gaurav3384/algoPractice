package array_hashing;

/**
 * Problem: Find Minimum in Rotated Sorted Array
 * Concepts: Array, Binary Search
 * 
 * Description:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * Find the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindMinRotatedSortedArray {

    /**
     * Solution: Binary Search (Optimal)
     * Strategy: Identify the sorted half and the rotated half. 
     * The minimum always lies in the rotated half (or at the start of a fully sorted subarray).
     * 
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * Example: nums = [3,4,5,1,2] -> Output: 1
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        // If the array is not rotated at all
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid is the minimum
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            
            // Check if mid+1 is the minimum
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            
            // Binary search logic
            if (nums[mid] >= nums[left]) {
                // Left half is sorted, min must be in the right half
                left = mid + 1;
            } else {
                // Right half is sorted, min must be in the left half
                right = mid - 1;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        FindMinRotatedSortedArray solver = new FindMinRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum: " + solver.findMin(nums));
    }
}
