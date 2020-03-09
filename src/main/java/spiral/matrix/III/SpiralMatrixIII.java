package spiral.matrix.III;

/**
 * @author hum
 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int r, int c, int r0, int c0) {
        int count = 0;
        int[][] result = new int[r * c][2];
        result[count][0] = r0;
        result[count][1] = c0;
        count++;
        int len = 1;
        int f = 0;

        while (count < r * c) {
            int tmp = len;
            while (tmp-- > 0) {
                if (f == 0) {
                    c0 = c0 + 1;
                    if (r0 >= 0 && r0 < r && c0 >= 0 && c0 < c) {
                        result[count][0] = r0;
                        result[count][1] = c0;
                        count++;
                    }
                } else if (f == 1) {
                    r0 = r0 + 1;
                    if (r0 >= 0 && r0 < r && c0 >= 0 && c0 < c) {
                        result[count][0] = r0;
                        result[count][1] = c0;
                        count++;
                    }
                } else if (f == 2) {
                    c0 = c0 - 1;
                    if (r0 >= 0 && r0 < r && c0 >= 0 && c0 < c) {
                        result[count][0] = r0;
                        result[count][1] = c0;
                        count++;
                    }

                } else if (f == 3) {
                    r0 = r0 - 1;
                    if (r0 >= 0 && r0 < r && c0 >= 0 && c0 < c) {
                        result[count][0] = r0;
                        result[count][1] = c0;
                        count++;
                    }
                }
            }
            f = (f + 1) % 4;
            if (f % 2 == 0) {
                len++;
            }
        }
        return result;
    }
}
