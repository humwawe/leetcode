package shortest.path.with.alternating.colors;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestPathWithAlternatingColors {
    int[] h1 = new int[105];
    int[] h2 = new int[105];
    int[] e1 = new int[405];
    int[] e2 = new int[405];
    int[] ne1 = new int[405];
    int[] ne2 = new int[405];
    int idx1 = 0;
    int idx2 = 0;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Arrays.fill(h1, -1);
        Arrays.fill(h2, -1);
        idx1 = 0;
        idx2 = 0;
        int[][] d = new int[n][2];
        boolean[][] vis = new boolean[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], 0x3f3f3f3f);
        }
        for (int[] redEdge : redEdges) {
            add1(redEdge[0], redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            add2(blueEdge[0], blueEdge[1]);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});
        vis[0][0] = true;
        vis[0][1] = true;
        d[0][0] = 0;
        d[0][1] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int a = poll[0];
            if (poll[1] == 0) {
                for (int i = h1[a]; i != -1; i = ne1[i]) {
                    int b = e1[i];
                    if (vis[b][1]) {
                        continue;
                    }
                    d[b][1] = d[a][0] + 1;
                    queue.add(new int[]{b, 1});
                    vis[b][1] = true;
                }
            } else {
                for (int i = h2[a]; i != -1; i = ne2[i]) {
                    int b = e2[i];
                    if (vis[b][0]) {
                        continue;
                    }
                    d[b][0] = d[a][1] + 1;
                    queue.add(new int[]{b, 0});
                    vis[b][0] = true;
                }
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = Math.min(d[i][0], d[i][1]);
            if (result[i] == 0x3f3f3f3f) {
                result[i] = -1;
            }
        }
        return result;
    }

    private void add1(int a, int b) {
        e1[idx1] = b;
        ne1[idx1] = h1[a];
        h1[a] = idx1++;
    }

    private void add2(int a, int b) {
        e2[idx2] = b;
        ne2[idx2] = h2[a];
        h2[a] = idx2++;
    }
}
