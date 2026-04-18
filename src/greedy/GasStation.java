package greedy;

/**
 * Problem: Gas Station
 * Concepts: Array, Greedy
 * 
 * Description:
 * There are n gas stations along a circular route, where the amount of gas 
 * at the ith station is gas[i]. You have a car with an unlimited gas tank and 
 * it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
 * Return the starting gas station's index if you can travel around the circuit 
 * once in the clockwise direction, otherwise return -1.
 */
public class GasStation {

    /**
     * Solution: Greedy Single Pass (Optimal)
     * Strategy:
     * 1. If total gas < total cost, completion is impossible.
     * 2. Otherwise, completion is guaranteed.
     * 3. Start from index 0. If gas in tank becomes negative at index i, 
     *    reset start to i + 1 and reset current tank.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;
        
        for (int i = 0; i < gas.length; i++) {
            totalSurplus += gas[i] - cost[i];
            currentSurplus += gas[i] - cost[i];
            
            // If current surplus is negative, we can't start at 'start' 
            // or any index between 'start' and 'i'.
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }
        
        return (totalSurplus < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        GasStation solver = new GasStation();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println("Start Index: " + solver.canCompleteCircuit(gas, cost)); // 3
    }
}
