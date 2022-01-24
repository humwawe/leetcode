package k.highest.ranked.items.within.a.price.range;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author hum
 */
public class KHighestRankedItemsWithinAPriceRange {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dist = new int[row][col];
        dist[start[0]][start[1]] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1]});
        int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        List<List<Integer>> res = new ArrayList<>();
        if (grid[start[0]][start[1]] >= pricing[0] && grid[start[0]][start[1]] <= pricing[1]) {
            List<Integer> list = new ArrayList<>();
            list.add(start[0]);
            list.add(start[1]);
            res.add(list);
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] f : fs) {
                int x = cur[0] + f[0];
                int y = cur[1] + f[1];
                if (x >= 0 && x < row && y >= 0 && y < col && dist[x][y] == 0 && grid[x][y] > 0) {
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{x, y});
                    if (grid[x][y] >= pricing[0] && grid[x][y] <= pricing[1]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(x);
                        list.add(y);
                        res.add(list);
                    }
                }
            }
        }
        res.sort((x, y) -> {
            int d = dist[x.get(0)][x.get(1)] - dist[y.get(0)][y.get(1)];
            if (d == 0) {
                int p = grid[x.get(0)][x.get(1)] - grid[y.get(0)][y.get(1)];
                if (p == 0) {
                    int c = x.get(0) - y.get(0);
                    if (c == 0) {
                        return x.get(1) - y.get(1);
                    }
                    return c;
                }
                return p;
            }
            return d;
        });
        return res.subList(0, Math.min(k, res.size()));
    }
}
