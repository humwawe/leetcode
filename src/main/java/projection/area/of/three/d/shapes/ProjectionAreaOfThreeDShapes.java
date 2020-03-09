package projection.area.of.three.d.shapes;

/**
 * @author hum
 */
public class ProjectionAreaOfThreeDShapes {
    public int projectionArea(int[][] grid) {
        int len = grid.length;
        int result = len * len;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
                a = Math.max(a, grid[i][j]);
                b = Math.max(b, grid[j][i]);
            }
            result += a;
            result += b;
        }
        return result - count;
    }
}
