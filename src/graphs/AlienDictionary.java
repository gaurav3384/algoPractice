package graphs;

import java.util.*;

/**
 * Problem: Alien Dictionary
 * Concepts: Graph, Topological Sort, BFS, DFS
 * 
 * Description:
 * There is a new alien language that uses the English alphabet. However, the order 
 * of the letters is unknown to you.
 * You are given a list of strings words from the alien language's dictionary, 
 * where the strings in words are sorted lexicographically by the rules of this new language.
 * Return a string of the unique letters in the new alien language sorted in lexicographical 
 * increasing order. If no valid order exists, return "".
 */
public class AlienDictionary {

    /**
     * Solution: Kahn's Algorithm (Topological Sort)
     * Strategy:
     * 1. Build adjacency list by comparing adjacent words.
     * 2. Perform topological sort.
     * 3. Handle edge cases like invalid cycles or invalid prefixes.
     * 
     * Time Complexity: O(C) where C is total length of all words.
     * Space Complexity: O(1) or O(U) where U is number of unique letters.
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                adj.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i+1];
            if (w1.length() > w2.length() && w1.startsWith(w2)) return "";
            
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if (c1 != c2) {
                    adj.get(c1).add(c2);
                    inDegree.put(c2, inDegree.get(c2) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (char c : inDegree.keySet()) {
            if (inDegree.get(c) == 0) queue.offer(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char neighbor : adj.get(c)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) queue.offer(neighbor);
            }
        }

        return (sb.length() < inDegree.size()) ? "" : sb.toString();
    }

    public static void main(String[] args) {
        AlienDictionary solver = new AlienDictionary();
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println("Order: " + solver.alienOrder(words)); // wertf
    }
}
