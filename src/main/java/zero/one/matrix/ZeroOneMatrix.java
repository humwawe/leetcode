package zero.one.matrix;

import java.util.Arrays;

public class ZeroOneMatrix {
    int[][] result;
    boolean[][] vis;
    int[][] fs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        result = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(result[i], -1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 0;
                } else if (matrix[i][j] == 1 && result[i][j] == -1) {
                    vis = new boolean[row][col];
                    result[i][j] = helper(matrix, i, j);
                }
            }
        }
        return result;
    }

    private int helper(int[][] matrix, int i, int j) {
        if (result[i][j] != -1) {
            return result[i][j];
        }
        if (matrix[i][j] == 0) {
            return 0;
        }
        vis[i][j]=true;
        int tmp = Integer.MAX_VALUE;
        for (int[] f : fs) {
            int newX = i + f[0];
            int newY = j + f[1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && !vis[newX][newY]) {
                tmp = Math.min(helper(matrix, newX, newY) + 1, tmp);
            }
        }
        return tmp;
    }

}
