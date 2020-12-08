package score.aftet.flipping.matrix;

/**
 * @author hum
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 0; i < row; i++) {
            if (arr[i][0] == 0) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = 1 - arr[i][j];
                }
            }
        }

        for (int i = 1; i < col; i++) {
            int count = 0;
            for (int j = 0; j < row; j++) {
                if (arr[j][i] == 0) {
                    count++;
                }
            }
            if (count * 2 > row) {
                for (int j = 0; j < row; j++) {
                    arr[j][i] = 1 - arr[j][i];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            int res = 0;
            for (int j = 0; j < col; j++) {
                res = res * 2 + arr[i][j];
            }
            result += res;
        }
        return result;
    }
}
