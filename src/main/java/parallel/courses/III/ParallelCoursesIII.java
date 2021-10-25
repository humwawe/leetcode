package parallel.courses.III;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class ParallelCoursesIII {
    int N = (int) (5e4 + 5);
    int M = N;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int[] dep = new int[N];

    public int minimumTime(int n, int[][] relations, int[] time) {
        Arrays.fill(h, -1);
        idx = 0;
        int[] dp = new int[n + 1];
        for (int[] relation : relations) {
            add(relation[0], relation[1]);
            dep[relation[1]]++;
        }
        int res = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (dep[i] == 0) {
                queue.add(i);
                dp[i] = time[i - 1];
                res = Math.max(res, dp[i]);
            }
        }
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                dep[j]--;
                dp[j] = Math.max(dp[j], dp[u] + time[j - 1]);
                res = Math.max(res, dp[j]);
                if (dep[j] == 0) {
                    queue.add(j);
                }
            }
        }
        return res;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
