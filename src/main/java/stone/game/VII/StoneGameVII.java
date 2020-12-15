package stone.game.VII;

/**
 * @author hum
 */
public class StoneGameVII {
    int[] s;
    int[] sum;
    Integer[][] memo;

    public int stoneGameVII(int[] stones) {
        s = stones;
        int len = stones.length;
        memo = new Integer[len][len];
        sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        return dfs(0, len - 1);
    }

    private int get(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    private int dfs(int i, int j) {
        if (i == j) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        memo[i][j] = Math.max(get(i, j - 1) - dfs(i, j - 1), get(i + 1, j) - dfs(i + 1, j));
        return memo[i][j];
    }
}
