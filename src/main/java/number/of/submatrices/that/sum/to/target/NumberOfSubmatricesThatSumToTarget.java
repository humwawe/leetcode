package number.of.submatrices.that.sum.to.target;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            int[] sum = new int[col];
            for (int j = i; j < row; j++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int s = 0;
                for (int k = 0; k < col; k++) {
                    sum[k] += matrix[j][k];
                    s += sum[k];
                    result += map.getOrDefault(s - target, 0);
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }
        }
        return result;
    }
}
