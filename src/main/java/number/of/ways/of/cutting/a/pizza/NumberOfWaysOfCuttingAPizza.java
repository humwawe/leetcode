package number.of.ways.of.cutting.a.pizza;

/**
 * @author hum
 */
public class NumberOfWaysOfCuttingAPizza {
    int row;
    int col;
    Integer[][][] memo = new Integer[55][55][15];
    int mod = (int) (1e9 + 7);

    public int ways(String[] pizza, int k) {
        row = pizza.length;
        col = pizza[0].length();
        int[][] sum = new int[row + 1][col + 1];
        for (int i = row - 1; i > -1; i--) {
            for (int j = col - 1; j > -1; j--) {
                sum[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + sum[i + 1][j] + sum[i][j + 1] - sum[i + 1][j + 1];
            }
        }
        return helper(sum, 0, 0, k - 1);
    }

    private int helper(int[][] sum, int i, int j, int k) {
        if (k == 0) {
            return sum[i][j] > 0 ? 1 : 0;
        }
        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }
        int res = 0;
        for (int l = i + 1; l <= row - 1; l++) {
            if (sum[i][j] - sum[l][j] > 0 && sum[l][j] > 0) {
                res += helper(sum, l, j, k - 1);
                res %= mod;
            }
        }
        for (int l = j + 1; l <= col - 1; l++) {
            if (sum[i][j] - sum[i][l] > 0 && sum[i][l] > 0) {
                res += helper(sum, i, l, k - 1);
                res %= mod;
            }
        }
        res %= mod;
        return memo[i][j][k] = res;
    }
}
