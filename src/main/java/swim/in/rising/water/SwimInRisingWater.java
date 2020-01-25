package swim.in.rising.water;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        Set<Integer> vis = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(k -> grid[k / N][k % N]));
        pq.offer(0);
        int result = 0;

        int[] dr = new int[]{1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 1, -1};

        while (!pq.isEmpty()) {
            int k = pq.poll();
            int x = k / N, y = k % N;
            result = Math.max(result, grid[x][y]);
            if (x == N - 1 && y == N - 1) {
                return result;
            }
            for (int i = 0; i < 4; ++i) {
                int newX = x + dr[i];
                int newY = y + dc[i];
                int num = newX * N + newY;
                if (0 <= newX && newX < N && 0 <= newY && newY < N && !vis.contains(num)) {
                    pq.offer(num);
                    vis.add(num);
                }
            }
        }
        return result;
    }

}
