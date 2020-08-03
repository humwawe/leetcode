package minimum.swaps.to.arrange.a.binary.grid;

/**
 * @author hum
 */
public class MinimumSwapsToArrangeABinaryGrid {
    public int minSwaps(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] a = new int[row];
        for (int i = 0; i < row; i++) {
            int count = 0;
            for (int j = col - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            a[i] = count;
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            boolean f = false;
            int idx = 0;
            for (int j = i; j < row; j++) {
                if (a[j] >= row - i - 1) {
                    res += j - i;
                    f = true;
                    idx = j;
                    break;
                }
            }
            if (!f) {
                return -1;
            }
            int t = a[idx];
            for (int k = idx; k >= i + 1; k--) {
                a[k] = a[k - 1];
            }
            a[i] = t;
        }
        return res;
    }
}
