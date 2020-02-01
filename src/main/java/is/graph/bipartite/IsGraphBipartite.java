package is.graph.bipartite;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] vis = new int[len];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (vis[i] == 0) {
                queue.add(i);
                vis[i] = 1;
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    int color = vis[poll];
                    for (int j : graph[i]) {
                        if (vis[j] == color) {
                            return false;
                        }
                        if (vis[j] == 0) {
                            vis[j] = -color;
                            queue.add(j);
                        }
                    }
                }
            }
        }
        return true;
    }
}
