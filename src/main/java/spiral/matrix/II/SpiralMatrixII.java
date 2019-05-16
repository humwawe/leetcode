package spiral.matrix.II;

/**
 * @author hum
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int indexX = 0, indexY = 0;
        int count = 0;
        result[0][0] = ++count;
        for (int i = 0; i < (n + 1) / 2; i++) {
            while (indexY < n - i - 1) {
                result[indexX][++indexY] = ++count;
            }

            while (indexX < n - i - 1) {
                result[++indexX][indexY] = ++count;
            }

            while (indexY > i) {

                result[indexX][--indexY] = ++count;
            }

            while (indexX > i + 1) {
                result[--indexX][indexY] = ++count;

            }
        }
        return result;
    }
}
