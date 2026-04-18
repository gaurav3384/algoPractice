package graphs;

import java.util.*;

/**
 * Problem: Alien Dictionary
 * Concepts: Graph, Topological Sort
 */
public class AlienDictionaryOptimal {

    /**
     * Solution: Kahn's Topological Sort (Optimal)
     * Time Complexity: O(Total characters in all words)
     * Space Complexity: O(1) - unique letters limited to 26.
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                inDegree.put(c, 0);
                adj.put(c, new HashSet<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    if (adj.get(c1).add(c2)) inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for (char c : inDegree.keySet()) if (inDegree.get(c) == 0) q.offer(c);
        
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next : adj.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) q.offer(next);
            }
        }
        
        return sb.length() == inDegree.size() ? sb.toString() : "";
    }

    public static void main(String[] args) {
        AlienDictionaryOptimal solver = new AlienDictionaryOptimal();
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println("Order: " + solver.alienOrder(words));
    }
}
