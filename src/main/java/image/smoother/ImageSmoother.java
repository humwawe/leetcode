package image.smoother;

/**
 * @author hum
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                double count = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int x = i + k;
                        int y = j + l;
                        if (x >= 0 && x < row && y >= 0 && y < col) {
                            result[i][j] += m[x][y];
                            count++;
                        }
                        result[i][j] = (int) Math.floor(result[i][j] / count);
                    }
                }

            }
        }
        return result;
    }
}
