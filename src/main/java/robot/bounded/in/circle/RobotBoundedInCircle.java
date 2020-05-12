package robot.bounded.in.circle;


/**
 * @author hum
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int index = 0;
        int[][] fs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0;
        int y = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                index = (index + 3) % 4;
            } else if (c == 'R') {
                index = (index + 1) % 4;
            } else {
                x += fs[index][0];
                y += fs[index][1];

            }
        }
        if (x == 0 && y == 0) {
            return true;
        }
        if (index == 0) {
            return false;
        }
        return true;
    }
}
