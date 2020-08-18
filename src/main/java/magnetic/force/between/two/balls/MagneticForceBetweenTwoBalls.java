package magnetic.force.between.two.balls;

import java.util.Arrays;

/**
 * @author hum
 */
public class MagneticForceBetweenTwoBalls {
    int[] p;

    public int maxDistance(int[] position, int m) {
        p = position;
        Arrays.sort(p);
        int l = 1;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, m)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int len, int m) {
        int start = (int) -1e9;
        int i = 0;
        int cnt = 0;
        while (i < p.length) {
            if (p[i] - start >= len) {
                start = p[i];
                cnt++;
            }
            if (cnt >= m) {
                return true;
            }
            i++;
        }
        return false;
    }
}
