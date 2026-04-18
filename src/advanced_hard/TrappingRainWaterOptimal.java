package advanced_hard;

/**
 * Problem: Trapping Rain Water (Optimal)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TrappingRainWaterOptimal {

    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = 0, rMax = 0, res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= lMax) lMax = height[l];
                else res += lMax - height[l];
                l++;
            } else {
                if (height[r] >= rMax) rMax = height[r];
                else res += rMax - height[r];
                r--;
            }
        }
        return res;
    }
}
