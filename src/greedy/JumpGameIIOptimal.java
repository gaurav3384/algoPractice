package greedy;

/**
 * Problem: Jump Game II
 * Concepts: Greedy, BFS
 */
public class JumpGameIIOptimal {

    /**
     * Solution: Greedy Range BFS (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameIIOptimal solver = new JumpGameIIOptimal();
        System.out.println("Min jumps: " + solver.jump(new int[]{2,3,1,1,4}));
    }
}
