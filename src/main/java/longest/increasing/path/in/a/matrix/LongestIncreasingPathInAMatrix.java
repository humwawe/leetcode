package longest.increasing.path.in.a.matrix;

/**
 * @author hum
 */
public class LongestIncreasingPathInAMatrix {
    int[] f1 = new int[]{-1, 0, 1, 0};
    int[] f2 = new int[]{0, 1, 0, -1};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int[][] memo = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (memo[i][j] != 0) {
                    continue;
                }
                result = Math.max(result, helper(matrix, i, j, memo));
            }
        }
        return result;
    }

    private int helper(int[][] matrix, int i, int j, int[][] memo) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + f1[k];
            int y = j + f2[k];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, helper(matrix, x, y, memo) + 1);
            }
        }
        memo[i][j] = max;
        return max;
    }
}
