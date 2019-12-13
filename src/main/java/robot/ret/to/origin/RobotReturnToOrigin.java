package robot.ret.to.origin;

/**
 * @author hum
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int l = 0;
        int u = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                l--;
            }
            if (c == 'L') {
                l++;
            }
            if (c == 'U') {
                u++;
            }
            if (c == 'D') {
                u--;
            }
        }
        return l == 0 && u == 0;
    }
}
