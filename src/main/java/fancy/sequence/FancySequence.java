package fancy.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FancySequence {
    long mul = 1;
    long add = 0;
    List<Integer> muls = new ArrayList<>();
    List<Integer> adds = new ArrayList<>();
    int[] v = new int[(int) (1e5 + 5)];
    int index = 0;
    int mod = (int) (1e9 + 7);

    public FancySequence() {

    }

    public void append(int val) {
        muls.add((int) mul);
        adds.add((int) add);
        v[index++] = val;
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;
    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int idx) {
        if (idx >= index) {
            return -1;
        }
        long m = mul * inv(muls.get(idx)) % mod;
        long a = (add - adds.get(idx) * m % mod + mod) % mod;
        return (int) ((m * v[idx] % mod + a) % mod);
    }

    int inv(int x) {
        return qp(x, mod - 2, mod);
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
