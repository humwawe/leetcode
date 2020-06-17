package the.k.weakest.rows.in.a.matrix;

import java.util.Arrays;

/**
 * @author hum
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        int[] t = new int[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                t[i] += mat[i][j];
            }
        }
        int[] result = new int[k];
        Integer[] idx = new Integer[row];
        for (int i = 0; i < row; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> t[a] == t[b] ? a - b : t[a] - t[b]);
        for (int i = 0; i < k; i++) {
            result[i] = idx[i];
        }
        return result;
    }
}
