package find.all.good.sttrings;


/**
 * @author hum
 */
public class FindAllGoodStrings {
    String evil;
    int[] next;
    int len;
    Integer[][] memo = new Integer[505][55];
    int mod = (int) (1e9 + 7);

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.evil = evil;
        len = evil.length();
        next = new int[len + 1];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < len) {
            while (j != -1 && evil.charAt(i) != evil.charAt(j)) {
                j = next[j];
            }
            next[++i] = ++j;
        }
        int t1 = helper(s2, 0, 0, true);
        int t2 = helper(s1, 0, 0, true);
        if (s1.contains(evil)) {
            return (t1 - t2 + mod) % mod;
        } else {
            return (t1 - t2 + mod) % mod + 1;
        }
    }

    private int helper(String s, int i, int count, boolean f) {
        if (count == len) {
            return 0;
        }
        if (i == s.length()) {
            return 1;
        }
        if (!f && memo[i][count] != null) {
            return memo[i][count];
        }
        char limit = f ? s.charAt(i) : 'z';
        long res = 0;
        for (char j = 'a'; j <= limit; j++) {
            if (j == evil.charAt(count)) {
                res += helper(s, i + 1, count + 1, f && j == limit);
            } else {
                int nex = count;
                while (nex > 0 && j != evil.charAt(nex)) {
                    nex = next[nex];
                }
                if (j == evil.charAt(nex)) {
                    nex++;
                }
                res += helper(s, i + 1, Math.max(nex, 0), f && j == limit);
            }
            res %= mod;
        }
        if (!f) {
            return memo[i][count] = (int) res % mod;
        }
        return (int) res % mod;
    }

}
