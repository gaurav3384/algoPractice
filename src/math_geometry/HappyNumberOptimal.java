package math_geometry;

/**
 * Problem: Happy Number
 */
public class HappyNumberOptimal {

    /**
     * Solution: Floyd's Cycle-Finding (Optimal)
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */
    public boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumberOptimal solver = new HappyNumberOptimal();
        System.out.println("Is 19 happy: " + solver.isHappy(19));
    }
}
