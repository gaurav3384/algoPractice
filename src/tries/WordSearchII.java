package tries;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Word Search II
 * Concepts: Array, String, Backtracking, Trie
 * 
 * Description:
 * Given an m x n board of characters and a list of strings words, 
 * return all words on the board.
 */
public class WordSearchII {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null; // Store the actual word at the leaf node
    }

    /**
     * Solution: Trie + Backtracking (Optimal)
     * Strategy: 
     * 1. Build a Trie from the input words.
     * 2. Perform DFS for each cell in the grid.
     * 3. Use the Trie to prune the search space early.
     * 
     * Time Complexity: O(M * (4 * 3^(L-1))) where M is cells, L is max word length.
     * Space Complexity: O(N) where N is total characters in words.
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        
        return res;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        char letter = board[r][c];
        if (letter == '#' || node.children[letter - 'a'] == null) return;
        
        node = node.children[letter - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // Prevent duplicates
        }
        
        board[r][c] = '#'; // Mark as visited
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                dfs(board, nr, nc, node, res);
            }
        }
        
        board[r][c] = letter; // Restore (backtrack)
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) curr.children[i] = new TrieNode();
                curr = curr.children[i];
            }
            curr.word = w;
        }
        return root;
    }

    public static void main(String[] args) {
        WordSearchII solver = new WordSearchII();
        char[][] board = {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        System.out.println("Found Words: " + solver.findWords(board, words));
    }
}
