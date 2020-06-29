package parallel.courses.II;

import java.util.Arrays;

/**
 * @author hum
 */
public class ParallelCoursesII {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] pre = new int[n];
        for (int[] dependency : dependencies) {
            dependency[0]--;
            dependency[1]--;
            pre[dependency[1]] |= (1 << dependency[0]);
        }
        int limit = 1 << n;
        int[] dp = new int[limit];
        Arrays.fill(dp, (int) 1e8);
        dp[0] = 0;
        for (int state = 0; state < limit; state++) {
            int next = 0;
            for (int i = 0; i < n; i++) {
                if ((state & pre[i]) == pre[i]) {
                    next |= 1 << i;
                }
            }
            next &= ~state;
            for (int sub = next; sub > 0; sub = (sub - 1) & next) {
                if (Integer.bitCount(sub) <= k) {
                    dp[state | sub] = Math.min(dp[state | sub], dp[state] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }

}
