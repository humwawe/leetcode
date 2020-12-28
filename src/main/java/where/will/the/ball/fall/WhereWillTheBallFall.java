package where.will.the.ball.fall;

/**
 * @author hum
 */
public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int col = grid[0].length;
        int[] res = new int[col];
        f:
        for (int i = 0; i < col; i++) {
            int t = i;
            for (int[] g : grid) {
                int x = g[t];
                if (t + x >= 0 && t + x < col && g[t + x] == x) {
                    t += x;
                } else {
                    res[i] = -1;
                    continue f;
                }
            }
            res[i] = t;
        }
        return res;
    }
}
