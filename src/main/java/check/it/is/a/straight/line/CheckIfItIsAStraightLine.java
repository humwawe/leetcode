package check.it.is.a.straight.line;

/**
 * @author hum
 */
public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            boolean pdline = (x - x1) * (y1 - y2) == (x1 - x2) * (y - y1);
            if (!pdline) {
                return false;
            }
        }
        return true;
    }
}
