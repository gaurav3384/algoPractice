package array_hashing;

/**
 * Problem: Container With Most Water
 * Concepts: Array, Two Pointers
 * 
 * Description:
 * You are given an integer array height of length n. 
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 */
public class ContainerWithMostWater {

    /**
     * Solution: Two Pointers (Optimal)
     * Strategy: Start with one pointer at the beginning and one at the end.
     * Calculate the area based on the shorter line. 
     * Move the pointer pointing to the shorter line inward, as moving the taller line inward 
     * will only decrease the area (shorter height or smaller width).
     * 
     * Time Complexity: O(n) - One pass through the array.
     * Space Complexity: O(1) - No extra space.
     * 
     * Example: height = [1,8,6,2,5,4,8,3,7] -> Output: 49
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solver = new ContainerWithMostWater();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Water Area: " + solver.maxArea(height));
    }
}
