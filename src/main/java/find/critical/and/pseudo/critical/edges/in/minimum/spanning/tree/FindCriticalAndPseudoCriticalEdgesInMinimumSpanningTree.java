package find.critical.and.pseudo.critical.edges.in.minimum.spanning.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {
    int[] p = new int[105];

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;
        int[][] newEdges = new int[len][4];
        for (int i = 0; i < len; i++) {
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, Comparator.comparingInt(o -> o[2]));

        List<Integer> realCri = new ArrayList<>();
        List<Integer> fakeCri = new ArrayList<>();
        int minCost = getExclude(n, newEdges, -1);
        for (int i = 0; i < len; i++) {
            if (getExclude(n, newEdges, i) > minCost) {
                realCri.add(i);
            } else if (getInclude(n, newEdges, i) == minCost) {
                fakeCri.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(realCri);
        result.add(fakeCri);
        return result;
    }


    private int getInclude(int n, int[][] edges, int edge) {
        int cost = 0;
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        for (int[] e : edges) {
            if (e[3] == edge) {
                int a = find(e[0]);
                int b = find(e[1]);
                p[a] = b;
                cost += e[2];
            }
        }
        for (int[] e : edges) {
            int a = find(e[0]);
            int b = find(e[1]);
            if (a != b) {
                p[a] = b;
                cost += e[2];
            }
        }
        return cost;
    }

    private int getExclude(int n, int[][] edges, int edge) {
        int cost = 0;
        for (int i = 0; i <= n; i++) {
            p[i] = i;
        }
        for (int[] e : edges) {
            if (e[3] == edge) {
                continue;
            }
            int a = find(e[0]);
            int b = find(e[1]);
            if (a != b) {
                p[a] = b;
                cost += e[2];
            }
        }
        return cost;
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
