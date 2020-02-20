package flipping.an.image;

/**
 * @author hum
 */
public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        boolean flag = col % 2 != 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int tmp = a[i][j];
                a[i][j] = 1 - a[i][col - j - 1];
                a[i][col - j - 1] = 1 - tmp;

            }
            if (flag) {
                a[i][col / 2] = 1 - a[i][col / 2];
            }
        }
        return a;
    }
}
