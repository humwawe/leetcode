package stone.game.VIII;

/**
 * @author hum
 */
public class StoneGameVIII {
    int n;
    int[] stones;
    int[] sum;
    Integer[] memo;

    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        this.stones = stones;

        memo = new Integer[n + 1];
        sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stones[i];
        }
        memo[n] = sum[n];
        return solve(2);
    }

    public int solve(int idx) {
        if (memo[idx] != null) {
            return memo[idx];
        }

        int res = Math.max(solve(idx + 1), sum[idx] - solve(idx + 1));
        return memo[idx] = res;
    }

}
