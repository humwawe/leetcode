package flower.planting.with.no.adjacent;

import java.util.Arrays;

/**
 * @author hum
 */
public class FlowerPlantingWithNoAdjacent {
    int[] h = new int[10005];
    int[] e = new int[40005];
    int[] ne = new int[40005];
    int idx;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    int[] color;

    public int[] gardenNoAdj(int n, int[][] paths) {
        Arrays.fill(h, -1);
        idx = 0;
        for (int[] path : paths) {
            add(path[0], path[1]);
            add(path[1], path[0]);
        }
        color = new int[n];
        for (int i = 1; i <= n; i++) {
            boolean[] vis = new boolean[5];
            for (int j = h[i]; j != -1; j = ne[j]) {
                int nn = e[j];
                vis[color[nn - 1]] = true;
            }
            for (int j = 1; j <= 4; j++) {
                if (!vis[j]) {
                    color[i - 1] = j;
                }

            }
        }
        return color;
    }
}
