package maximum.product.of.the.length.of.two.palindromic.substrings;

/**
 * @author hum
 */
public class MaximumProductOfTheLengthOfTwoPalindromicSubstrings {
    int[] mp;
    int n;

    public long maxProduct(String s) {
        n = s.length();
        mp = new int[n];
        manacher(s.toCharArray());
        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i + mp[i] - 1] = Math.max(pre[i + mp[i] - 1], 2 * mp[i] - 1);
            suf[i - mp[i] + 1] = Math.max(suf[i - mp[i] + 1], 2 * mp[i] - 1);
        }
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i], pre[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            pre[i] = Math.max(pre[i], pre[i + 1] - 2);
        }

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i], suf[i + 1]);
        }
        for (int i = 1; i < n; i++) {
            suf[i] = Math.max(suf[i], suf[i - 1] - 2);
        }

        long res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, (long) pre[i] * suf[i + 1]);
        }
        return res;

    }

    void manacher(char[] s) {

        mp[0] = 1;
        int mx = 0, id = 0;
        for (int i = 1; i < n; i++) {
            mp[i] = mx > i ? Math.min(mp[2 * id - i], mx - i) : 1;
            // 如果没有哨兵，比如求奇数回文串，可以直接在原串上处理，需要保证 i - mp[i] >= 0 && i + mp[i] < size
            while (i + mp[i] < n && i - mp[i] >= 0 && s[i + mp[i]] == s[i - mp[i]]) {
                mp[i]++;
            }
            if (i + mp[i] > mx) {
                mx = i + mp[i];
                id = i;
            }
        }
    }
}
