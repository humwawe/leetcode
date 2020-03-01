package shortest.path.visiting.all.nodes;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int len = graph.length;
        if (graph.length == 0) {
            return 0;
        }
        boolean[][] vis = new boolean[len][1 << len];
        int finishState = (1 << len) - 1;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{i, 1 << i});
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                if (finishState == node[1]) {
                    return result;
                }
                for (int next : graph[node[0]]) {
                    int nextState = node[1] | (1 << next);
                    if (vis[next][nextState]) {
                        continue;
                    }
                    vis[next][nextState] = true;
                    queue.offer(new int[]{next, nextState});
                }
            }
            result++;
        }
        return result;
    }
}
