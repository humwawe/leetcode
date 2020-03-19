package cat.and.mouse;

import java.util.Arrays;

/**
 * @author hum
 */
public class CatAndMouse {
    int[][][] memo = new int[50][50][100];
    int[][] g;

    public int catMouseGame(int[][] graph) {
        g = graph;
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return helper(1, 2, 0);
    }

    private int helper(int mouse, int cat, int step) {
        if (step == g.length * 2) {
            return 0;
        }
        if (cat == mouse) {
            return memo[mouse][cat][step] = 2;
        }
        if (mouse == 0) {
            return memo[mouse][cat][step] = 1;
        }
        if (memo[mouse][cat][step] != -1) {
            return memo[mouse][cat][step];
        }
        boolean mouseStep = step % 2 == 0;
        if (mouseStep) {
            int res = 2;
            for (int i : g[mouse]) {
                int tmp = helper(i, cat, step + 1);
                if (tmp == 1) {
                    res = 1;
                    break;
                } else if (tmp == 0) {
                    res = 0;
                }
            }
            return memo[mouse][cat][step] = res;
        } else {
            int res = 1;
            for (int i : g[cat]) {
                if (i == 0) {
                    continue;
                }
                int tmp = helper(mouse, i, step + 1);
                if (tmp == 2) {
                    res = 2;
                    break;
                } else if (tmp == 0) {
                    res = 0;
                }
            }
            return memo[mouse][cat][step] = res;
        }
    }
}
