package count.sub.islands;

/**
 * @author hum
 */
public class CountSubIslands {
    int row, col;
    int[][] fs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] grid1, grid2;
    boolean flag;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        row = grid1.length;
        col = grid1[0].length;
        this.grid1 = grid1;
        this.grid2 = grid2;

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1) {
                    flag = true;
                    dfs(i, j);
                    if (flag) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j) {
        if (grid1[i][j] == 0) {
            flag = false;
        }
        grid2[i][j] = 0;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < row && y >= 0 && y < col && grid2[x][y] == 1) {
                dfs(x, y);
            }
        }
    }
}
