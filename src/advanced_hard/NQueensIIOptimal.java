package advanced_hard;

/**
 * Problem: N-Queens II
 */
public class NQueensIIOptimal {

    private int count = 0;

    /**
     * Solution: Bitmask Backtracking (Optimal)
     * Time Complexity: O(N!)
     * Space Complexity: O(N)
     */
    public int totalNQueens(int n) {
        backtrack(0, 0, 0, 0, n);
        return count;
    }

    private void backtrack(int r, int cols, int d1, int d2, int n) {
        if (r == n) {
            count++;
            return;
        }
        int available = ((1 << n) - 1) & (~(cols | d1 | d2));
        while (available != 0) {
            int pos = available & -available;
            available &= ~pos;
            backtrack(r + 1, cols | pos, (d1 | pos) << 1, (d2 | pos) >> 1, n);
        }
    }

    public static void main(String[] args) {
        NQueensIIOptimal solver = new NQueensIIOptimal();
        System.out.println("Result (8): " + solver.totalNQueens(8));
    }
}
