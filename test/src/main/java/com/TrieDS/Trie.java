package com.TrieDS;

public class Trie {
    TrieNode root;

    class TrieNode {
        TrieNode[] node = new TrieNode[26];
        boolean end;
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';

            if (curr.node[ind] != null) {
                curr = curr.node[ind];
            } else {
                curr.node[ind] = new TrieNode();
                curr = curr.node[ind];
            }
        }
        curr.end = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (curr.node[ind] != null) {
                curr = curr.node[ind];
            } else {
                return false;
            }
        }
        return curr.end == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i) - 'a';
            if (curr.node[ind] != null) {
                curr = curr.node[ind];
            } else {
                return false;
            }
        }
        return true;
    }
}
