package minimum.height.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        int[] point = new int[n];
        boolean[] visit = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = true;
            graph[edges[i][1]][edges[i][0]] = true;
            point[edges[i][0]]++;
            point[edges[i][1]]++;
        }
        while (n > 2) {
            for (int i = 0; i < point.length; i++) {
                if (point[i] == 1) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                Integer v = queue.poll();
                n--;
                point[v]--;
                visit[v] = true;
                for (int i = 0; i < graph[v].length; i++) {
                    if (graph[v][i]) {
                        point[i]--;
                        graph[v][i] = false;
                        graph[i][v] = false;
                    }
                }

            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
