package advanced_hard;

import java.util.*;

/**
 * Problem: Word Ladder II
 * Concepts: Hash Table, String, BFS, Backtracking
 * 
 * Description:
 * Find all shortest transformation sequences from beginWord to endWord.
 */
public class WordLadderII {

    /**
     * Solution: BFS + Backtracking (Optimal)
     * Strategy:
     * 1. BFS to build a predecessor map and find the shortest distance.
     * 2. Backtrack (DFS) from endWord to beginWord to reconstruct all paths.
     * 
     * Time Complexity: O(M^2 * N + NumberOfPaths * M)
     * Space Complexity: O(M^2 * N)
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        bfs(beginWord, endWord, dict, adj, distance);
        
        if (distance.containsKey(endWord)) {
            backtrack(endWord, beginWord, adj, new LinkedList<>(Arrays.asList(endWord)), res);
        }
        
        return res;
    }

    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> adj, Map<String, Integer> distance) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);
        
        while (!q.isEmpty()) {
            String curr = q.poll();
            int dist = distance.get(curr);
            
            char[] chars = curr.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char old = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String next = new String(chars);
                    if (dict.contains(next) || next.equals(start)) {
                        if (!distance.containsKey(next)) {
                            distance.put(next, dist + 1);
                            adj.computeIfAbsent(next, k -> new ArrayList<>()).add(curr);
                            q.offer(next);
                        } else if (distance.get(next) == dist + 1) {
                            adj.get(next).add(curr);
                        }
                    }
                }
                chars[i] = old;
            }
        }
    }

    private void backtrack(String curr, String start, Map<String, List<String>> adj, LinkedList<String> path, List<List<String>> res) {
        if (curr.equals(start)) {
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            res.add(validPath);
            return;
        }
        
        if (adj.containsKey(curr)) {
            for (String prev : adj.get(curr)) {
                path.add(prev);
                backtrack(prev, start, adj, path, res);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        WordLadderII solver = new WordLadderII();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Paths: " + solver.findLadders("hit", "cog", list));
    }
}
