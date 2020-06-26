package allocate.mailboxes;

import java.util.Arrays;

/**
 * @author hum
 */
public class AllocateMailboxes {
    int[] h;
    int len;
    int inf = (int) 1e8;
    int k;
    Integer[][] memo = new Integer[(int) (105)][105];

    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        this.h = houses;
        len = houses.length;
        this.k = k;
        return helper(0, 0);
    }

    private int helper(int i, int b) {
        if (i == len) {
            if (b == k) {
                return 0;
            }
            return inf;
        }
        if (b > k) {
            return inf;
        }
        if (memo[i][b] != null) {
            return memo[i][b];
        }
        int res = inf;
        for (int j = i; j < len; j++) {
            int m = (j - i) / 2 + i;
            int d = 0;
            for (int k = i; k <= j; k++) {
                d += Math.abs(h[k] - h[m]);
            }
            res = Math.min(res, helper(j + 1, b + 1) + d);
        }
        return memo[i][b] = res;
    }
}
