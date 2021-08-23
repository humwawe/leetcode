package minimize.the.difference.between.target.and.chosen.elements;

/**
 * @author hum
 */
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
    public int minimizeTheDifference(int[][] mat, int target) {
        int N = 5005;
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] dp = new boolean[row + 1][N];
        dp[0][0] = true;
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < col; j++) {
                int num = mat[i - 1][j];
                for (int k = num; k < N; k++) {
                    dp[i][k] |= dp[i - 1][k - num];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++) {
            if (dp[row][k]) {
                res = Math.min(res, Math.abs(k - target));
            }
        }

        return res;
    }

}