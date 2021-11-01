package minimum.operations.to.convert.number;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        int[] dist = new int[1005];
        boolean[] vis = new boolean[1005];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;
        vis[start] = true;
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            int d = dist[u];
            for (int num : nums) {
                int x = u + num;
                if (x == goal) {
                    return d + 1;
                }
                if (x >= 0 && x <= 1000 && !vis[x]) {
                    queue.add(x);
                    vis[x] = true;
                    dist[x] = d + 1;
                }
                x = u - num;
                if (x == goal) {
                    return d + 1;
                }
                if (x >= 0 && x <= 1000 && !vis[x]) {
                    queue.add(x);
                    vis[x] = true;
                    dist[x] = d + 1;
                }
                x = u ^ num;
                if (x == goal) {
                    return d + 1;
                }
                if (x >= 0 && x <= 1000 && !vis[x]) {
                    queue.add(x);
                    vis[x] = true;
                    dist[x] = d + 1;
                }
            }
        }
        return -1;
    }
}
