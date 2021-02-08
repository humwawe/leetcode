package maximum.number.of.events.that.can.be.attended.II;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MaximumNumberOfEventsThatCanBeAttendedII {
    int len;
    int[][] e;
    int k;
    Integer[][] memo;

    public int maxValue(int[][] events, int k) {
        e = events;
        len = events.length;
        this.k = k;
        memo = new Integer[len + 1][k + 1];
        Arrays.sort(e, Comparator.comparingInt(x -> x[0]));

        return helper(0, 0);
    }

    private int helper(int pos, int cnt) {
        if (pos == len) {
            return 0;
        }
        if (cnt == k) {
            return 0;
        }
        if (memo[pos][cnt] != null) {
            return memo[pos][cnt];
        }
        int res = 0;
        res = Math.max(res, helper(pos + 1, cnt));
        int idx = find(e[pos][1]);
//        int idx = find2(pos);
        res = Math.max(res, helper(idx, cnt + 1) + e[pos][2]);
        return memo[pos][cnt] = res;
    }

    private int find2(int pos) {
        for (int i = pos + 1; i < len; i++) {
            if (e[i][0] > e[pos][1]) {
                return i;
            }
        }
        return len;
    }

    private int find(int v) {
        int l = 0;
        int r = e.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (e[mid][0] > v) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
