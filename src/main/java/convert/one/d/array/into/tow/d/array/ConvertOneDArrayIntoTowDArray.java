package convert.one.d.array.into.tow.d.array;

/**
 * @author hum
 */
public class ConvertOneDArrayIntoTowDArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] res = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[idx++];
            }
        }
        return res;
    }
}
