package number.of.unique.good.subsequences;

/**
 * @author hum
 */
public class NumberOfUniqueGoodSubsequences {
    public int numberOfUniqueGoodSubsequences(String binary) {
        boolean f = false;
        int o = 0;
        int e = 0;
        int mod = (int) (1e9 + 7);
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                f = true;
                e = (e + o) % mod;
            } else {
                o = (e + o + 1) % mod;
            }
        }
        int res = 0;
        if (f) {
            res++;
        }
        res = (res + o + e) % mod;
        return res;
    }
}
