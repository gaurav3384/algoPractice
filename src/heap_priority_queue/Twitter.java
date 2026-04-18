package heap_priority_queue;

import java.util.*;

/**
 * Problem: Design Twitter
 * Concepts: Hash Table, Linked List, Design, Heap
 * 
 * Description:
 * Design a simplified version of Twitter where users can post tweets, 
 * follow/unfollow others, and see the 10 most recent tweets in their news feed.
 */
public class Twitter {

    private static int timestamp = 0;
    
    private class Tweet {
        int id;
        int time;
        Tweet next;
        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    private class User {
        int id;
        Set<Integer> followed;
        Tweet tweetHead;
        
        User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id); // Follow self
        }
        
        void follow(int id) { followed.add(id); }
        void unfollow(int id) { if (id != this.id) followed.remove(id); }
        void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweetHead;
            tweetHead = t;
        }
    }

    private Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }
    
    /**
     * News Feed: 10 most recent tweets from self and followed users.
     * Strategy: Use a Max-Heap (PriorityQueue) to merge sorted tweet lists.
     * Time Complexity: O(k log N) where k=10 and N is number of followed users.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if (!userMap.containsKey(userId)) return res;
        
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        for (int id : users) {
            Tweet t = userMap.get(id).tweetHead;
            if (t != null) pq.offer(t);
        }
        
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet t = pq.poll();
            res.add(t.id);
            count++;
            if (t.next != null) pq.offer(t.next);
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId)) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1)); // [5]
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1)); // [6, 5]
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [5]
    }
}
