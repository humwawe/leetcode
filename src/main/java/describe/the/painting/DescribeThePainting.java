package describe.the.painting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class DescribeThePainting {
    public List<List<Long>> splitPainting(int[][] segments) {
        int n = 100010;
        long[] segs = new long[n];
        boolean[] split = new boolean[n];
        for (int[] segment : segments) {
            int left = segment[0];
            int right = segment[1];
            int color = segment[2];
            segs[left] += color;
            segs[right] -= color;
            split[left] = true;
            split[right] = true;
        }

        List<List<Long>> res = new ArrayList<>();
        long cur = 0, l = -1;
        for (int i = 0; i < n; i++) {
            if (split[i]) {
                if (l > 0 && cur > 0) {
                    res.add(Arrays.asList(l, (long) i, cur));
                }
                l = i;
            }
            cur += segs[i];
        }
        return res;
    }
}
