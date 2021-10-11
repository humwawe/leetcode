package minimum.operations.to.make.a.uni.value.grid;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumOperationsToMakeAUniValueGrid {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] tmp = new int[n * m];
        int idx = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                tmp[idx++] = ints[j];
            }
        }
        Arrays.sort(tmp);
        int res = tmp[n * m / 2];
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            int t = Math.abs(tmp[i] - res);
            if (t % x != 0) {
                return -1;
            }
            cnt += t / x;
        }
        return cnt;
    }
}
