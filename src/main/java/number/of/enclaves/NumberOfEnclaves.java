package number.of.enclaves;

/**
 * @author hum
 */
public class NumberOfEnclaves {
    int count = 0;
    boolean flag = false;
    int[][] fs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numEnclaves(int[][] a) {
        int row = a.length;
        int col = a[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] == 1) {
                    count = 0;
                    flag = false;
                    helper(a, i, j);
                    if (flag) {
                        result += count;
                    }
                }
            }
        }
        return result;
    }

    private void helper(int[][] a, int i, int j) {
        a[i][j] = 0;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x < 0 || x >= a.length || y < 0 || y >= a[0].length) {
                flag = true;
            } else if (a[x][y] == 1) {
                count++;
                helper(a, x, y);
            }
        }
    }
}
