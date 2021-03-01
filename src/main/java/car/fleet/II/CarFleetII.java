package car.fleet.II;

import java.util.Stack;

/**
 * @author hum
 */
public class CarFleetII {
    public double[] getCollisionTimes(int[][] cars) {
        int len = cars.length;
        double[] res = new double[len];
        Stack<Integer> s = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!s.isEmpty()) {
                if (cars[i][1] <= cars[s.peek()][1]) {
                    s.pop();
                } else {
                    if (res[s.peek()] < 0) {
                        break;
                    }
                    if ((double) (cars[s.peek()][0] - cars[i][0]) / (double) (cars[i][1] - cars[s.peek()][1]) < res[s.peek()]) {
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
            if (s.empty()) {
                res[i] = -1.0;
            } else {
                res[i] = (double) (cars[s.peek()][0] - cars[i][0]) / (double) (cars[i][1] - cars[s.peek()][1]);
            }
            s.push(i);
        }
        return res;
    }
}
