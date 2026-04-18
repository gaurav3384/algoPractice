package dynamic_programming_1d;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Coin Change
 * Concepts: BFS, Shortest Path, Dynamic Programming
 */
public class CoinChangeBFS {

    /**
     * Solution: BFS (Shortest Path in Graph)
     * Strategy: Each amount is a node. Coins are edges. 
     * Find shortest path from amount to 0.
     * 
     * Time Complexity: O(amount * n)
     * Space Complexity: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(amount);
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;
        
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int coin : coins) {
                    int next = curr - coin;
                    if (next == 0) return steps;
                    if (next > 0 && !visited[next]) {
                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CoinChangeBFS solver = new CoinChangeBFS();
        int[] coins = {1, 2, 5};
        System.out.println("Result: " + solver.coinChange(coins, 11)); // 3
    }
}
