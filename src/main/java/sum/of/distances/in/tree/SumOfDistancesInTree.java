package sum.of.distances.in.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class SumOfDistancesInTree {
    List<Integer>[] graph;
    int[] result;
    int[] count;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new List[n];
        result = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        helper(0, -1);
        helper2(0, -1);
        return result;
    }

    private void helper2(int cur, int p) {
        for (Integer child : graph[cur]) {
            if (child != p) {
                result[child] = result[cur] + graph.length - count[child] - count[child];
            }
        }
    }

    private void helper(int cur, int p) {
        for (Integer child : graph[cur]) {
            if (child != p) {
                helper(child, cur);
                count[cur] += count[child];
                result[cur] += result[child] + count[child];
                helper2(child, cur);
            }
        }
    }
}
