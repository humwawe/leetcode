package lucky.numbers.in.a.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] rows = new int[row];
        int[] cols = new int[col];
        Arrays.fill(rows, Integer.MAX_VALUE);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                rows[i] = Math.min(cur, rows[i]);
                cols[j] = Math.max(cur, cols[j]);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j];
                if (cur == rows[i] && cur == cols[j]) {
                    result.add(cur);
                }
            }
        }
        return result;
    }
}
