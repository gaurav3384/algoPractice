package math_geometry;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: Happy Number
 * Concepts: Hash Table, Two Pointers
 * 
 * Description:
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the 
 * squares of its digits. Repeat the process until the number equals 1 (happy), 
 * or it loops endlessly in a cycle which does not include 1.
 */
public class HappyNumber {

    /**
     * Solution 1: Floyd's Cycle-Finding (Optimal Space)
     * Strategy: Use slow and fast pointers to detect a cycle in the sequence.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return fast == 1;
    }

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        HappyNumber solver = new HappyNumber();
        System.out.println("Is 19 happy: " + solver.isHappy(19)); // true
    }
}
