package linked_list;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: LRU Cache
 * Concepts: Hash Table, Linked List, Design
 * 
 * Description:
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * - LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * - int get(int key) Return the value of the key if it exists, otherwise return -1.
 * - void put(int key, int value) Update the value if key exists, otherwise add the key-value pair.
 *   If the number of keys exceeds the capacity, evict the least recently used key.
 */
public class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    /**
     * Solution: HashMap + Doubly Linked List (Optimal)
     * Strategy:
     * - Use a HashMap for O(1) lookups.
     * - Use a Doubly Linked List to maintain the order of usage.
     * - Head of list = Most recently used, Tail of list = Least recently used.
     * 
     * Time Complexity: O(1) for both get and put.
     * Space Complexity: O(capacity).
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        insert(new Node(key, value));
        map.put(key, head.next);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 1
        lru.put(3, 3); // evicts 2
        System.out.println(lru.get(2)); // -1
    }
}
