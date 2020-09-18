package min.cost.to.connect.all.points;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class MinCostToConnectAllPoints {
    int N = 1005;
    int[] p = new int[N];

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        int len = points.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        edges.sort(Comparator.comparingInt(a -> a.w));
        for (int i = 0; i < len; i++) {
            p[i] = i;
        }
        int res = 0;
        for (Edge edge : edges) {
            int a = edge.a;
            int b = edge.b;
            int w = edge.w;
            a = find(a);
            b = find(b);
            if (a != b) {
                res += w;
                p[a] = b;
            }
        }
        return res;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}
