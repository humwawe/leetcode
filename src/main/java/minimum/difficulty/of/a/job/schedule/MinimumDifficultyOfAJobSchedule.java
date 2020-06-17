package minimum.difficulty.of.a.job.schedule;

/**
 * @author hum
 */
public class MinimumDifficultyOfAJobSchedule {
    int[][] m;
    int len;
    int inf = (int) 1e9;
    Integer[][] memo;

    public int minDifficulty(int[] jobDifficulty, int d) {
        len = jobDifficulty.length;
        if (d > len) {
            return -1;
        }
        memo = new Integer[len][d + 1];
        m = new int[len][len];
        for (int i = 0; i < len; i++) {
            int max = jobDifficulty[i];
            for (int j = i; j < len; j++) {
                max = Math.max(max, jobDifficulty[j]);
                m[i][j] = max;
            }
        }
        return helper(0, d);
    }

    private int helper(int i, int d) {
        if (i >= len) {
            if (d == 0) {
                return 0;
            }
            return inf;
        }
        if (d > len - i || d <= 0) {
            return inf;
        }

        if (memo[i][d] != null) {
            return memo[i][d];
        }
        int res = inf;
        for (int j = i; j < len; j++) {
            res = Math.min(res, m[i][j] + helper(j + 1, d - 1));
        }
        return memo[i][d] = res;
    }
}
