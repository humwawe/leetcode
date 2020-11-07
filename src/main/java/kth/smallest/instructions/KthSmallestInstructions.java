package kth.smallest.instructions;

/**
 * @author hum
 */
public class KthSmallestInstructions {
    public String kthSmallestPath(int[] destination, int k) {
        combination();
        int row = destination[0];
        int col = destination[1];
        return helper(row, col, k);

    }

    private String helper(int row, int col, int k) {
        if (row == 0) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < col; i++) {
                res.append("H");
            }
            return res.toString();
        }
        if (col == 0) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < row; i++) {
                res.append("V");
            }
            return res.toString();
        }
        if (c[row + col - 1][col - 1] >= k) {
            return "H" + helper(row, col - 1, k);
        } else {
            return "V" + helper(row - 1, col, k - c[row + col - 1][col - 1]);
        }
    }

    int N = 31;
    int[][] c = new int[N][N];
    int mod = (int) (1e9 + 7);

    // 递归法求组合数 N^2
    void combination() {
        // c[a][b] 表示从a个里中选b个的方案数
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    c[i][j] = 1;
                } else {
                    c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]);
                }
            }
        }
    }
}
