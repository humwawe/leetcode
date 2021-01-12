package find.minimum.time.to.finish.all.jobs;

/**
 * @author hum
 */
public class FindMinimumTimeToFinishAllJobs {
    int[] work = new int[15];
    int[] jobs;
    int k;
    int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        this.jobs = jobs;
        this.k = k;
        dfs(0, 0, 0);
        return res;
    }

    private void dfs(int pos, int cnt, int max) {
        if (max > res) {
            return;
        }
        if (pos == jobs.length) {
            res = max;
            return;
        }
        for (int i = 0; i <= cnt; i++) {
            work[i] += jobs[pos];
            dfs(pos + 1, cnt, Math.max(max, work[i]));
            work[i] -= jobs[pos];
        }
        if (cnt < k - 1) {
            work[cnt + 1] += jobs[pos];
            dfs(pos + 1, cnt + 1, Math.max(max, work[cnt + 1]));
            work[cnt + 1] -= jobs[pos];
        }
    }
}
