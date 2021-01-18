package largest.submatrix.with.rearrangements;

import java.util.Arrays;

/**
 * @author hum
 */
public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] sum = new int[col];
        int res = 0;
        for (int i = 0; i < row; i++) {
            int[] num = new int[col];
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    sum[j] = 0;
                } else {
                    sum[j] += matrix[i][j];
                }
                num[j] = sum[j];
            }
            Arrays.sort(num);
            for (int j = 0; j < col; j++) {
                res = Math.max(res, num[j] * (col - j));
            }
        }
        return res;
    }
}
