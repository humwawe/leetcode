package dungeon.game;


/**
 * @author hum
 */
public class DungeonGame {
    private int row;
    private int col;
    private int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            dp[i][col] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < col; i++) {
            dp[row][i] = Integer.MAX_VALUE;
        }
        dp[row][col - 1] = 1;
        dp[row - 1][col] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];

//        memo = new int[row][col];
//        return helper(dungeon, 0, 0);

    }


    private int helper(int[][] dungeon, int i, int j) {
        if (i == row - 1 && j == col - 1) {
            memo[i][j] = Math.max(1, 1 - dungeon[i][j]);
            return memo[i][j];
        }
        if (i >= row || j >= col) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int right = helper(dungeon, i, j + 1);
        int down = helper(dungeon, i + 1, j);
        memo[i][j] = Math.max(1, Math.min(right, down) - dungeon[i][j]);
        return memo[i][j];
    }
}
