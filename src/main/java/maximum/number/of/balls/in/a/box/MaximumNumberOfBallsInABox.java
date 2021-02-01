package maximum.number.of.balls.in.a.box;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumNumberOfBallsInABox {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int t = i;
            int x = 0;
            while (t > 0) {
                x += t % 10;
                t /= 10;
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
            max = Math.max(max, map.get(x));
        }
        return max;
    }
}
