package com.TrieDS;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True

        System.out.println();

        DesignAddandSearchWordDataStructure ds = new DesignAddandSearchWordDataStructure();
        ds.addWord("bad");
        ds.addWord("dad");
        ds.addWord("mad");
        System.out.println(ds.search("pad")); // return False
        System.out.println(ds.search("bad")); // return False
        System.out.println(ds.search(".ad")); // return True
        System.out.println(ds.search("b..")); // return True

    }
}