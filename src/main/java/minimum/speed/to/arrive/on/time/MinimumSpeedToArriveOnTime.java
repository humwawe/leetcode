package minimum.speed.to.arrive.on.time;

/**
 * @author hum
 */
public class MinimumSpeedToArriveOnTime {
    int[] dist;

    public int minSpeedOnTime(int[] dist, double hour) {
        int len = dist.length;
        if (len - 1 >= hour) {
            return -1;
        }
        this.dist = dist;
        int l = 1;
        int r = (int) 1e7;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid) <= hour) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private double check(int v) {
        double h = 0;
        int t = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            t += (dist[i] + v - 1) / v;
        }
        h += (double) dist[dist.length - 1] / v + t;
        return h;
    }
}
