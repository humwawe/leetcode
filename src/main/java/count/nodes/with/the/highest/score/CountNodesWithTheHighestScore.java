package count.nodes.with.the.highest.score;

import java.util.Arrays;

/**
 * @author hum
 */
public class CountNodesWithTheHighestScore {
    int N = 100010;
    int M = N;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int[] size = new int[N];
    long[] mul = new long[N];
    int res = 0;
    int[] parents;
    long allSize, maxScore;

    public int countHighestScoreNodes(int[] parents) {
        Arrays.fill(h, -1);
        idx = 0;
        this.parents = parents;
        allSize = parents.length;
        for (int i = 1; i < parents.length; i++) {
            add(parents[i], i);
        }
        maxScore = 0;
        res = 0;
        dfs(0);
        return res;
    }

    private void dfs(int u) {
        size[u] = 1;
        int t = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            dfs(j);
            size[u] += size[j];
            t *= size[j];
        }
        mul[u] = t;
        long tmp = t;
        if (u != 0) {
            tmp *= allSize - size[u];
        }
        if (maxScore < tmp) {
            maxScore = tmp;
            res = 1;
        } else if (maxScore == tmp) {
            res++;
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
