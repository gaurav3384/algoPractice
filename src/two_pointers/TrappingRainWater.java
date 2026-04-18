package two_pointers;

/**
 * Problem: Trapping Rain Water
 * Concepts: Array, Two Pointers, Dynamic Programming, Stack
 * 
 * Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 */
public class TrappingRainWater {

    /**
     * Solution 1: Dynamic Programming (Precomputing Max)
     * Strategy: For each element, the water trapped is min(maxLeft, maxRight) - currentHeight.
     * Precompute maxLeft and maxRight for all indices.
     * 
     * Time Complexity: O(n) - Three passes.
     * Space Complexity: O(n) - Two extra arrays.
     */
    public int trapDP(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return totalWater;
    }

    /**
     * Solution 2: Two Pointers (Optimal)
     * Strategy: Use two pointers (left, right) and track leftMax and rightMax.
     * If height[left] < height[right], process left and update leftMax.
     * Otherwise, process right and update rightMax.
     * 
     * Time Complexity: O(n) - One pass.
     * Space Complexity: O(1) - Two variables only.
     * 
     * Example: height = [0,1,0,2,1,0,1,3,2,1,2,1] -> Output: 6
     */
    public int trapOptimal(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    totalWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Water: " + solver.trapOptimal(height));
    }
}
