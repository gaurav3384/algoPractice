package binary_search;

import java.util.Arrays;

/**
 * Problem: Koko Eating Bananas
 * Concepts: Array, Binary Search
 * 
 * Description:
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
 * The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile 
 * of bananas and eats k bananas from that pile. If the pile has less than k bananas, 
 * she eats all of them instead and will not eat any more bananas during this hour.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class KokoEatingBananas {

    /**
     * Solution: Binary Search on Result Space (Optimal)
     * Strategy: The range of possible speeds is [1, max(piles)].
     * Use binary search to find the smallest 'k' that allows finishing within 'h' hours.
     * 
     * Time Complexity: O(n * log(max(piles)))
     * Space Complexity: O(1)
     * 
     * Example: piles = [3,6,7,11], h = 8 -> Output: 4
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) right = Math.max(right, p);
        
        int res = right;
        
        while (left <= right) {
            int k = left + (right - left) / 2;
            long hours = 0; // Use long to avoid overflow
            
            for (int p : piles) {
                // Calculate ceiling of p/k
                hours += (p + k - 1) / k;
            }
            
            if (hours <= h) {
                res = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        KokoEatingBananas solver = new KokoEatingBananas();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Min Speed: " + solver.minEatingSpeed(piles, h));
    }
}
