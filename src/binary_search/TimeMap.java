package binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Time Based Key-Value Store
 * Concepts: Hash Table, String, Binary Search, Design
 * 
 * Description:
 * Design a time-based key-value data structure that can store multiple values 
 * for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 */
public class TimeMap {

    private class Node {
        String value;
        int timestamp;
        Node(String v, int t) {
            value = v;
            timestamp = t;
        }
    }

    private Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    /**
     * Set: Stores key, value, and timestamp.
     * Time Complexity: O(1)
     */
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(value, timestamp));
    }
    
    /**
     * Get: Returns the value such that timestamp_prev <= timestamp. 
     * If multiple, returns the largest timestamp_prev.
     * Strategy: Since timestamps are added in increasing order, use binary search on the list.
     * 
     * Time Complexity: O(log N) where N is the number of values for the key.
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<Node> list = map.get(key);
        int left = 0, right = list.size() - 1;
        String res = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // bar
        System.out.println(timeMap.get("foo", 3)); // bar
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // bar2
        System.out.println(timeMap.get("foo", 5)); // bar2
    }
}
