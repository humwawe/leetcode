package zero.one.matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class ZeroOneMatrix {


    public int[][] updateMatrix(int[][] matrix) {
        int[][] fs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int row = matrix.length;
        if (row == 0) {
            return matrix;
        }
        int col = matrix[0].length;
        int[][] result = new int[row][col];
        for (int[] res : result) {
            Arrays.fill(res, Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] f : fs) {
                int newX = poll[0] + f[0];
                int newY = poll[1] + f[1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                    if (result[newX][newY] > result[poll[0]][poll[1]]) {
                        result[newX][newY] = result[poll[0]][poll[1]] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
        return result;
    }
}
