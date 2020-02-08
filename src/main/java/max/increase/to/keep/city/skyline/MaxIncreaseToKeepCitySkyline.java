package max.increase.to.keep.city.skyline;

/**
 * @author hum
 */
public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length;
        int[][] tmp = new int[len][2];
        for (int i = 0; i < len; i++) {
            tmp[i][0] = grid[i][0];
            tmp[i][1] = grid[0][i];
            for (int j = 0; j < len; j++) {
                tmp[i][0] = Math.max(tmp[i][0], grid[i][j]);
                tmp[i][1] = Math.max(tmp[i][1], grid[j][i]);
            }
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result += Math.min(tmp[i][0], tmp[j][1]) - grid[i][j];
            }
        }
        return result;
    }
}
