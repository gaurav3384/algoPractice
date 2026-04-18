package greedy;

import java.util.TreeMap;

/**
 * Problem: Hand of Straights
 * Concepts: Array, Hash Table, Greedy, Sorting
 * 
 * Description:
 * Alice has some number of cards and she wants to rearrange the cards into groups 
 * so that each group is of size groupSize, and consists of groupSize consecutive cards.
 * Return true if she can, or false otherwise.
 */
public class HandOfStraights {

    /**
     * Solution: TreeMap Greedy (Optimal)
     * Strategy:
     * 1. Count frequencies of cards using a TreeMap (sorted keys).
     * 2. Repeatedly pick the smallest card and try to form a straight group of size 'groupSize'.
     * 3. If a consecutive card is missing, return false.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) count.put(card, count.getOrDefault(card, 0) + 1);
        
        while (!count.isEmpty()) {
            int first = count.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!count.containsKey(card)) return false;
                
                int c = count.get(card);
                if (c == 1) count.remove(card);
                else count.put(card, c - 1);
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights solver = new HandOfStraights();
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        System.out.println("Can form: " + solver.isNStraightHand(hand, 3)); // true
    }
}
