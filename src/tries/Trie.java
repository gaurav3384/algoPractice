package tries;

/**
 * Problem: Implement Trie (Prefix Tree)
 * Concepts: Tree, Trie, Design
 * 
 * Description:
 * A trie (pronounced as "try") or prefix tree is a tree data structure used 
 * to efficiently store and retrieve keys in a dataset of strings.
 */
public class Trie {

    private class TrieNode {
        private TrieNode[] children;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    /**
     * Inserts a word into the trie.
     * Time Complexity: O(L) where L is word length.
     */
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEndOfWord = true;
    }
    
    /**
     * Returns true if the word is in the trie.
     * Time Complexity: O(L)
     */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEndOfWord;
    }
    
    /**
     * Returns true if there is any word in the trie that starts with the given prefix.
     * Time Complexity: O(L)
     */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String s) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) return null;
            curr = curr.children[index];
        }
        return curr;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("Search apple: " + trie.search("apple"));   // true
        System.out.println("Search app: " + trie.search("app"));       // false
        System.out.println("StartsWith app: " + trie.startsWith("app")); // true
    }
}
