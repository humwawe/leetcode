package the.number.of.good.subsets;

/**
 * @author hum
 */
public class TheNumberOfGoodSubsets {
    public int numberOfGoodSubsets(int[] nums) {
        int[] prime = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int len = nums.length;
        int cnt1 = 0;
        int[] map = new int[35];
        f:
        for (int x = 2; x <= 30; x++) {
            int sum = 0;
            int i = x;
            for (int j = 0; j < prime.length; j++) {
                int cnt = 0;
                while (i % prime[j] == 0) {
                    i /= prime[j];
                    cnt++;
                }
                if (cnt > 1) {
                    map[x] = 0;
                    continue f;
                }
                if (cnt == 1) {
                    sum |= 1 << j;
                }

            }
            map[x] = sum;
        }
        int lim = 1 << 10;
        int[] cnt = new int[lim];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                cnt1++;
                continue;
            }
            if (map[nums[i]] != 0) {
                cnt[map[nums[i]]]++;
            }
        }
        long[] dp = new long[lim];
        int mod = (int) (1e9 + 7);
        long res = 0;
        dp[0] = 1;
        for (int i = 0; i < lim; i++) {
            for (int j = i + 1; j < lim; j++) {
                if ((i & j) != 0) {
                    continue;
                }
                dp[j | i] = (dp[j | i] + dp[i] * cnt[j]) % mod;
            }
        }
        for (int i = 1; i < lim; i++) {
            res = (res + dp[i]) % mod;
        }
        return (int) (res * qp(2, cnt1, mod) % mod);

    }

    int qp(int m, int k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res % p;
    }
}
