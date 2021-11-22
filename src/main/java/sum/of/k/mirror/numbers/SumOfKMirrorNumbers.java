package sum.of.k.mirror.numbers;

/**
 * @author hum
 */
public class SumOfKMirrorNumbers {
    long res = 0;
    int[] nums = new int[10];
    int len = 1;
    long[] p = new long[60];
    int k;
    int n;

    public long kMirror(int k, int n) {
        this.k = k;
        this.n = n;
        p[0] = 1;
        for (int i = 1; i < 60; i++) {
            p[i] = p[i - 1] * k;
        }
        while (len < 60) {
            dfs(0, 0);
            len++;
        }
        return res;
    }

    private void dfs(int u, long v) {
        if (n == 0) {
            return;
        }
        if (u == (len + 1) / 2) {
            if (check(v)) {
                n--;
                res += v;
            }
            return;
        }
        for (int i = 0; i < k; i++) {
            if (v == 0 && i == 0) {
                continue;
            }
            if (len - u - 1 == u) {
                dfs(u + 1, v + i * +p[u]);
            } else {
                dfs(u + 1, v + i * (p[len - u - 1] + p[u]));
            }
        }
    }

    private boolean check(long v) {
        String s = String.valueOf(v);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
