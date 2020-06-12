package count.servers.that.communicate;

/**
 * @author hum
 */
public class CountServersThatCommunicate {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] r = new int[row];
        int[] c = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    r[i]++;
                    c[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && (r[i] > 1 || c[j] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }
}
