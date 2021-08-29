package find.array.given.subset.sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FindArrayGivenSubsetSums {
    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        List<Integer> res = dfs(n, sums);
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private List<Integer> dfs(int n, int[] sums) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            if (sums[0] == 0) {
                res.add(sums[1]);
                return res;
            }
            if (sums[1] == 0) {
                res.add(sums[0]);
                return res;
            }
            return res;
        }

        int d = sums[1] - sums[0];
        int left = 0, right = 0;
        int[] s = new int[1 << (n - 1)];
        int[] t = new int[1 << (n - 1)];
        int sIdx = 0;
        int tIdx = 0;
        boolean[] vis = new boolean[1 << n];
        while (true) {
            while (left < (1 << n) && vis[left]) {
                ++left;
            }
            if (left == (1 << n)) {
                break;
            }
            s[sIdx++] = sums[left];
            vis[left] = true;
            while (vis[right] || sums[right] != sums[left] + d) {
                ++right;
            }
            t[tIdx++] = sums[right];
            vis[right] = true;
        }
        res = dfs(n - 1, s);

        if (!res.isEmpty()) {
            res.add(d);
            return res;
        }
        res = dfs(n - 1, t);
        if (!res.isEmpty()) {
            res.add(-d);
            return res;
        }
        return res;
    }
}
