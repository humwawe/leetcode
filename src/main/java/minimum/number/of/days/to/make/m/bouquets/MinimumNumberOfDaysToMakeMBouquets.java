package minimum.number.of.days.to.make.m.bouquets;

/**
 * @author hum
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if (m * k > len) {
            return -1;
        }
        int l = 0;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + r >> 1;
            int count = 0;
            int res = 0;
            for (int i = 0; i < len; i++) {
                if (bloomDay[i] > mid) {
                    res += count / k;
                    count = 0;
                } else {
                    count++;
                }
            }
            if (count > 0) {
                res += count / k;
            }
            if (res >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
