package redundant.connection;

import java.util.*;

/**
 * @author hum
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] inDegrees = new int[n];
        for (int[] edge : edges) {
            inDegrees[edge[0] - 1]++;
            inDegrees[edge[1] - 1]++;
        }
        while (true) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 1) {
                    flag = true;
                    for (int[] edge : edges) {
                        if (edge[0] == i + 1 || edge[1] == i + 1) {
                            inDegrees[edge[0] - 1]--;
                            inDegrees[edge[1] - 1]--;
                        }
                    }
                }
            }
            if (!flag) {
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 2) {
                set.add(i + 1);
            }
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            if (set.contains(edges[i][0]) && set.contains(edges[i][1])) {
                return edges[i];
            }
        }
        return new int[2];
    }

}
