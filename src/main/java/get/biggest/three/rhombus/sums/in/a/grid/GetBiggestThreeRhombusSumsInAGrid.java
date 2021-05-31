package get.biggest.three.rhombus.sums.in.a.grid;

import java.util.TreeSet;

/**
 * @author hum
 */
public class GetBiggestThreeRhombusSumsInAGrid {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum1 = new int[m + 5][n + 5];
        int[][] sum2 = new int[m + 5][n + 5];
        TreeSet<Integer> set = new TreeSet<>((x, y) -> y - x);
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                sum1[i][j] = sum1[i - 1][j - 1] + grid[i - 1][j - 1];
                sum2[i][j] = sum2[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                set.add(grid[i - 1][j - 1]);
                for (int k = 1; i + k <= m && i - k >= 1 && j + k <= n && j - k >= 1; ++k) {
                    int a = sum1[i + k][j] - sum1[i][j - k];
                    int b = sum1[i][j + k] - sum1[i - k][j];
                    int c = sum2[i + k][j] - sum2[i][j + k];
                    int d = sum2[i][j - k] - sum2[i - k][j];
                    set.add(a + b + c + d - grid[i + k - 1][j - 1] + grid[i - k - 1][j - 1]);
                }
                System.out.println(set);
                while (set.size() > 3) {
                    set.pollLast();
                }
            }
        }
        int[] res = new int[set.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = set.pollFirst();
        }
        return res;
    }
}
