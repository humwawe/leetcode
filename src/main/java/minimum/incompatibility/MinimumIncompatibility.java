package minimum.incompatibility;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumIncompatibility {
    int[] nums;
    int k;
    int c;
    int len;
    int inf = (int) 1e8;
    int[] cache;
    int[] dp;

    public int minimumIncompatibility(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        c = nums.length / k;
        len = nums.length;
        int[] cnt = new int[len + 1];
        for (int num : nums) {
            cnt[num]++;
            if (cnt[num] > k) {
                return -1;
            }
        }

        int lim = 1 << len;
        dp = new int[lim];
        Arrays.fill(dp, inf);
        cache = new int[lim];
        Arrays.fill(cache, inf);

        int comb = (1 << c) - 1;
        while (comb < lim) {
            genCache(comb);
            int x = comb & -comb;
            int y = comb + x;
            comb = ((comb & ~y) / x >> 1) | y;
        }

        dp[0] = 0;
        for (int cur = 0; cur < lim; cur++) {
            for (int sub = cur; sub > 0; sub = (sub - 1) & cur) {
                if (cache[sub] == inf) {
                    continue;
                }
                dp[cur] = Math.min(dp[cur], dp[cur ^ sub] + cache[sub]);
            }
        }

        int res = dp[lim - 1];
        if (res >= inf) {
            return -1;
        }
        return res;
    }

    private void genCache(int comb) {
        cache[comb] = check(comb);
    }

    private int check(int cur) {
        int min = 100;
        int max = 0;
        boolean[] vis = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            if (((cur >> i) & 1) == 1) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i]);
                if (vis[nums[i]]) {
                    return inf;
                }
                vis[nums[i]] = true;
            }
        }
        return max - min;
    }
}
