package math_geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Spiral Matrix
 * Concepts: Matrix, Array
 */
public class SpiralMatrixOptimal {

    /**
     * Solution: Layer-by-Layer simulation (Optimal)
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rs = 0, re = matrix.length - 1;
        int cs = 0, ce = matrix[0].length - 1;
        
        while (rs <= re && cs <= ce) {
            for (int j = cs; j <= ce; j++) res.add(matrix[rs][j]);
            rs++;
            for (int i = rs; i <= re; i++) res.add(matrix[i][ce]);
            ce--;
            if (rs <= re) {
                for (int j = ce; j >= cs; j--) res.add(matrix[re][j]);
                re--;
            }
            if (cs <= ce) {
                for (int i = re; i >= rs; i--) res.add(matrix[i][cs]);
                cs++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrixOptimal solver = new SpiralMatrixOptimal();
        int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("Result: " + solver.spiralOrder(m));
    }
}
