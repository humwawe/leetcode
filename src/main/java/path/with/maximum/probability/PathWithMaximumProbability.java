package path.with.maximum.probability;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class PathWithMaximumProbability {
    int[] h = new int[(int) (1e4 + 5)];
    int[] e = new int[(int) (4e4 + 5)];
    int[] ne = new int[(int) (4e4 + 5)];
    double[] w = new double[(int) (4e4 + 5)];
    int idx;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 0; i < edges.length; i++) {
            add(edges[i][0], edges[i][1], succProb[i]);
            add(edges[i][1], edges[i][0], succProb[i]);
        }
        PriorityQueue<P> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.w, a.w));
        priorityQueue.add(new P(start, 1));
        double[] ps = new double[n];
        boolean[] vis = new boolean[n];
        while (!priorityQueue.isEmpty()) {
            P poll = priorityQueue.poll();
            vis[poll.p] = true;
            for (int i = h[poll.p]; i != -1; i = ne[i]) {
                int j = e[i];
                if (vis[j]) {
                    continue;
                }
                if (w[i] * poll.w > ps[j]) {
                    ps[j] = w[i] * poll.w;
                    priorityQueue.add(new P(j, ps[j]));
                }
            }
        }
        return ps[end];

    }


    void add(int a, int b, double v) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = v;
        h[a] = idx++;
    }

    class P {
        int p;
        double w;

        public P(int p, double w) {
            this.p = p;
            this.w = w;
        }
    }
}
