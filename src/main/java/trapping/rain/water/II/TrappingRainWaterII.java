package trapping.rain.water.II;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hum
 */
public class TrappingRainWaterII {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        Queue<Cell> queue = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = visited[i][n - 1] = true;
            queue.add(new Cell(i, 0, heightMap[i][0]));
            queue.add(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        for (int i = 1; i < n - 1; i++) {
            visited[0][i] = visited[m - 1][i] = true;
            queue.add(new Cell(0, i, heightMap[0][i]));
            queue.add(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        int result = 0;
        int[][] bounds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] bound : bounds) {
                int row = cell.row + bound[0];
                int col = cell.col + bound[1];
                if (row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]) {
                    result += Math.max(0, cell.height - heightMap[row][col]);
                    visited[row][col] = true;
                    queue.add(new Cell(row, col, Math.max(cell.height, heightMap[row][col])));
                }
            }
        }
        return result;
    }

    private class Cell {
        private int row;
        private int col;
        private int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

}
