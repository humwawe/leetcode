package time.needed.to.inform.all.employees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class TimeNeededToInformAllEmployees {
    int[] h = new int[(int) 1e5 + 5];
    int[] e = new int[(int) 2e5 + 5];
    int[] ne = new int[(int) 2e5 + 5];
    int[] w = new int[(int) 2e5 + 5];
    int idx;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) {
                continue;
            }
            add(manager[i], i, informTime[i]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n];
        queue.add(headID);
        dist[headID] = informTime[headID];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = h[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                dist[j] = dist[poll] + w[i];
                queue.add(j);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dist[i]);
        }
        return result;
    }

    void add(int a, int b, int wei) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = wei;
        h[a] = idx++;
    }

    int[] d;

    public int numOfMinutes2(int n, int headID, int[] manager, int[] informTime) {
        d = new int[n];
        Arrays.fill(d, -1);
        d[headID] = informTime[headID];
        for (int i = 0; i < n; i++) {
            if (d[i] == -1) {
                helper(i, manager, informTime);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, d[i]);
        }
        return result;
    }

    private int helper(int i, int[] manager, int[] informTime) {
        if (d[i] != -1) {
            return d[i];
        }
        return d[i] = informTime[i] + helper(manager[i],manager,informTime);
    }
}
