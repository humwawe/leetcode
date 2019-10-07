package pacific.atlantic.water.flow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PacificAtlanticWaterFlow {
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int col = matrix[0].length;

        int[][] dp1 = new int[row][col];
        int[][] dp2 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp1[i][j] == 0) {
                    boolean[][] vis1 = new boolean[row][col];
                    helper1(matrix, dp1, i, j, vis1);
                    if (dp1[i][j] != 1) {
                        dp1[i][j] = -1;
                    }
                }
                if (dp2[i][j] == 0) {
                    boolean[][] vis2 = new boolean[row][col];
                    helper2(matrix, dp2, i, j, vis2);
                    if (dp2[i][j] != 1) {
                        dp2[i][j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dp1[i][j] == 1 && dp2[i][j] == 1) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    result.add(tmp);
                }
            }
        }

        return result;


    }

    private void helper1(int[][] matrix, int[][] dp1, int i, int j, boolean[][] vis1) {
        if (dp1[i][j] != 0) {
            return;
        }
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x < 0 || y < 0) {
                dp1[i][j] = 1;
                return;
            }
            if (x == matrix.length || y == matrix[0].length) {
                continue;
            }
            vis1[i][j] = true;
            if (matrix[x][y] <= matrix[i][j] && !vis1[x][y]) {
                helper1(matrix, dp1, x, y, vis1);
                if (dp1[x][y] == 1) {
                    dp1[i][j] = 1;
                    return;
                }
            }
            vis1[i][j] = false;
        }
//        dp1[i][j] = -1;
    }

    private void helper2(int[][] matrix, int[][] dp2, int i, int j, boolean[][] vis2) {
        if (dp2[i][j] != 0) {
            return;
        }
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x == matrix.length || y == matrix[0].length) {
                dp2[i][j] = 1;
                return;
            }
            if (x < 0 || y < 0) {
                continue;
            }
            vis2[i][j] = true;
            if (matrix[x][y] <= matrix[i][j] & !vis2[x][y]) {
                helper2(matrix, dp2, x, y, vis2);
                if (dp2[x][y] == 1) {
                    dp2[i][j] = 1;
                    return;
                }
            }
            vis2[i][j] = false;
        }
//        dp2[i][j] = -1;
    }
}
