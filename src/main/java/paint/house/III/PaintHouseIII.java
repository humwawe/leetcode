package paint.house.III;

/**
 * @author hum
 */
public class PaintHouseIII {
    int[] h;
    int[][] c;
    int m;
    int n;
    int t;
    Integer[][][] memo = new Integer[105][25][105];
    int inf = (int) 1e8;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.h = houses;
        this.c = cost;
        this.m = m;
        this.n = n;
        this.t = target;
        int tmp = helper(0, 0, 0);
        if (tmp == inf) {
            return -1;
        }
        return tmp;
    }

    private int helper(int i, int prev, int b) {
        if (i == m) {
            if (b == t) {
                return 0;
            }
            return inf;
        }
        if (b > t) {
            return inf;
        }
        if (memo[i][prev][b] != null) {
            return memo[i][prev][b];
        }
        int res = inf;
        if (h[i] == 0) {
            for (int j = 1; j <= n; j++) {
                int tmp = 0;
                if (prev == j) {
                    tmp = 0;
                } else {
                    tmp = 1;
                }
                res = Math.min(res, helper(i + 1, j, b + tmp) + c[i][j - 1]);
            }
        } else {
            int tmp = 0;
            if (h[i] == prev) {
                tmp = 0;
            } else {
                tmp = 1;
            }
            res = Math.min(res, helper(i + 1, h[i], b + tmp));
        }
        return memo[i][prev][b] = res;
    }
}
