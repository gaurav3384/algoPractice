package advanced_hard;

import java.util.*;

/**
 * Problem: Word Ladder
 * Concepts: Hash Table, String, Breadth-First Search
 * 
 * Description:
 * A transformation sequence from word beginWord to word endWord using a 
 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk 
 * such that every adjacent pair differs by a single letter.
 * Return the number of words in the shortest transformation sequence.
 */
public class WordLadder {

    /**
     * Solution: BFS (Optimal)
     * Strategy: Use BFS to find the shortest path in an undirected graph 
     * where edges exist between words that differ by one letter.
     * 
     * Time Complexity: O(M^2 * N) where M is word length and N is wordList size.
     * Space Complexity: O(M^2 * N)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int steps = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) return steps;
                
                char[] chars = curr.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String next = new String(chars);
                        if (dict.contains(next)) {
                            queue.offer(next);
                            dict.remove(next); // Mark as visited
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            steps++;
        }
        
        return 0;
    }

    public static void main(String[] args) {
        WordLadder solver = new WordLadder();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("Length: " + solver.ladderLength("hit", "cog", list)); // 5
    }
}
