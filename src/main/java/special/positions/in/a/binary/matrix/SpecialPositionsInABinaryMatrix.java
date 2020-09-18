package special.positions.in.a.binary.matrix;

/**
 * @author hum
 */
public class SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        int result = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] += mat[i][j];
                col[j] += mat[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
