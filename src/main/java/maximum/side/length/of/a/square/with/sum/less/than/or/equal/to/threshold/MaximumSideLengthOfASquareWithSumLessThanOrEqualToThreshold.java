package maximum.side.length.of.a.square.with.sum.less.than.or.equal.to.threshold;

/**
 * @author hum
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int row = mat.length;
        int col = mat[0].length;
        int result = 0;
        int[][] sum = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = mat[i - 1][j - 1] + sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                for (int k = result; k <= i && k <= j; k++) {
                    int ans = sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k];
                    if (ans > threshold) {
                        break;
                    }
                    result = Math.max(result, k);
                }
            }
        }
        return result;
    }
}
