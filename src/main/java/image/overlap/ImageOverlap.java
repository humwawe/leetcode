package image.overlap;

/**
 * @author hum
 */
public class ImageOverlap {
    public int largestOverlap(int[][] a, int[][] b) {
        int len = a.length;
        int[][] count = new int[len * 2][len * 2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (a[i][j] == 1) {
                    for (int k = 0; k < len; k++) {
                        for (int l = 0; l < len; l++) {
                            if (b[k][l] == 1) {
                                count[k - i + len][l - j + len]++;
                            }
                        }
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 2 * len; i++) {
            for (int j = 0; j < 2 * len; j++) {
                result = Math.max(result, count[i][j]);
            }
        }
        return result;
    }
}
