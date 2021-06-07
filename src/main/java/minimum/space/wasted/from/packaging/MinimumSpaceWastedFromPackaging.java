package minimum.space.wasted.from.packaging;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumSpaceWastedFromPackaging {
    int last;
    int mod = (int) (1e9 + 7);

    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        int len = packages.length;
        long[] sum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + packages[i];
        }
        long res = Long.MAX_VALUE;
        for (int[] box : boxes) {
            long cur = 0;
            last = 0;
            Arrays.sort(box);
            if (box[box.length - 1] >= packages[len - 1]) {
                for (int b : box) {
                    int idx = find(packages, b);
                    cur += (long) b * (idx - last) - (sum[idx] - sum[last]);
                    last = idx;
                }
                res = Math.min(res, cur);
            }
        }
        if (res == Long.MAX_VALUE) {
            return -1;
        }
        return (int) (res % mod);
    }

    private int find(int[] packages, int num) {
        int i = last;
        int j = packages.length;
        while (i < j) {
            int mid = i + j >> 1;
            if (packages[mid] <= num) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}