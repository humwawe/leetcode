package surface.area.of.three.d.shapes;

/**
 * @author hum
 */
public class SurfaceAreaOfThreeDShapes {
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int len = grid.length;
        int result = 0;

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (grid[i][j] > 0) {
                    result += 2;
                    for (int k = 0; k < 4; ++k) {
                        int x = i + dr[k];
                        int y = j + dc[k];
                        int res = 0;
                        if (0 <= x && x < len && 0 <= y && y < len) {
                            res = grid[x][y];
                        }
                        result += Math.max(grid[i][j] - res, 0);
                    }
                }
            }
        }
        return result;
    }
}
