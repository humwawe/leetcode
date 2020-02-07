package bricks.falling.when.hit;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author hum
 */
public class BricksFallingWhenHit {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int[] count;
    int[] parent;

    public int[] hitBricks(int[][] grid, int[][] hits) {

        int m = grid.length, n = grid[0].length;
        buildUnionFind(m * n + 1);
        for (int i = 0; i < hits.length; i++) {
            if (grid[hits[i][0]][hits[i][1]] == 1) {
                grid[hits[i][0]][hits[i][1]] = 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionAround(grid, i, j);
                }
            }
        }

        int[] rst = new int[hits.length];
        int currCount = count[find(0)];
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 2) {
                unionAround(grid, x, y);
                grid[x][y] = 1;
            }
            int newCount = count[find(0)];
            rst[i] = newCount > currCount ? newCount - currCount - 1 : 0;
            currCount = newCount;
        }

        return rst;
    }

    private void unionAround(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i], nY = y + dy[i];
            if (!validate(grid, nX, nY)) {
                continue;
            }
            union(x * n + y + 1, nX * n + nY + 1);
        }
        if (x == 0) {
            union(x * n + y + 1, 0);
        }
    }


    private void buildUnionFind(int size) {
        parent = new int[size];
        count = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            count[i] = 1;
        }
    }

    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            parent[parentX] = parentY;
            count[parentY] += count[parentX];
        }
    }

    private boolean validate(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1;
    }
}
