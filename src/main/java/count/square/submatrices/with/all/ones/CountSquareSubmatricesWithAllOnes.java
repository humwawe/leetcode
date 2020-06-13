package count.square.submatrices.with.all.ones;

/**
 * @author hum
 */
public class CountSquareSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int result = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == 0) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                result += dp[i][j];
            }
        }
        return result;
    }
}
