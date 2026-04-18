package tries;

/**
 * Problem: Design Add and Search Words Data Structure
 * Concepts: Tree, Trie, Design, Backtracking
 * 
 * Description:
 * Design a data structure that supports adding new words and finding if a string 
 * matches any previously added string.
 * The string may contain dots '.' which can match any letter.
 */
public class WordDictionary {

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    /**
     * Adds a word into the data structure.
     * Time Complexity: O(L)
     */
    public void addWord(String word) {
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
     * Returns true if the word is in the data structure (handles wildcards).
     * Time Complexity: O(M) for direct search, O(26^L) worst case for wildcards.
     */
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;
        
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchInNode(word, index + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return searchInNode(word, index + 1, node.children[c - 'a']);
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        System.out.println("Search pad: " + dict.search("pad")); // false
        System.out.println("Search bad: " + dict.search("bad")); // true
        System.out.println("Search .ad: " + dict.search(".ad")); // true
        System.out.println("Search b..: " + dict.search("b..")); // true
    }
}
