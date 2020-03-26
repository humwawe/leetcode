package shortest.bridge;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author hum
 */
public class ShortestBridge {
    Queue<int[]> queue = new ArrayDeque<>();
    int[][] fs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] a) {
        int len = a.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (flag) {
                break;
            }
            for (int j = 0; j < len; j++) {
                if (a[i][j] == 1) {
                    helper(a, i, j);
                    flag = true;
                    break;
                }
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                for (int[] f : fs) {
                    int x = poll[0] + f[0];
                    int y = poll[1] + f[1];
                    if (x >= 0 && x < a.length && y >= 0 && y < a.length) {
                        if (a[x][y] == 0) {
                            queue.add(new int[]{x, y});
                            a[x][y] = 2;
                        } else if (a[x][y] == 1) {
                            return result;
                        }
                    }
                }
            }
            result++;
        }
        return result;
    }

    private void helper(int[][] a, int i, int j) {
        a[i][j] = 2;
        queue.add(new int[]{i, j});
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < a.length && y >= 0 && y < a.length && a[x][y] == 1) {
                helper(a, x, y);
            }
        }
    }
}
