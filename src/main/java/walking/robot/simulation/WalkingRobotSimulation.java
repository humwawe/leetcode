package walking.robot.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int[][] fs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int k = 0;
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int p = 0, q = 0;
        for (int command : commands) {
            if (command == -1) {
                k = (k + 1) % 4;
            } else if (command == -2) {
                k = (k + 4 - 1) % 4;
            } else {
                int f[] = fs[k];
                for (int i = 0; i < command; i++) {
                    if (set.contains((p + f[0]) + "," + (q + f[1]))) {
                        break;
                    }
                    p += f[0];
                    q += f[1];
                }
                max = Math.max(max, p * p + q * q);
            }
        }
        return max;
    }
}
