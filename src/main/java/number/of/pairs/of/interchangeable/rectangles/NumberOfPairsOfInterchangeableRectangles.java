package number.of.pairs.of.interchangeable.rectangles;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hum
 */
public class NumberOfPairsOfInterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<P, Integer> map = new HashMap<>();
        long res = 0;
        for (int[] rectangle : rectangles) {
            int x = rectangle[0];
            int y = rectangle[1];
            int gcd = gcd(x, y);
            x /= gcd;
            y /= gcd;
            P p = new P(x, y);
            if (map.containsKey(p)) {
                res += map.get(p);
            }
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        return res;
    }

    class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            P p = (P) o;
            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }
}
