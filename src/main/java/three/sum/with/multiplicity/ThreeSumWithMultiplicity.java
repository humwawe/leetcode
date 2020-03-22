package three.sum.with.multiplicity;

import java.util.*;

/**
 * @author hum
 */
public class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] a, int target) {
        long[] count = new long[105];
        Set<Integer> set = new HashSet<>();
        for (int i : a) {
            count[i]++;
            set.add(i);
        }
        List<Integer> res = new ArrayList<>(set);
        Collections.sort(res);
        long result = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < res.size(); i++) {
            int l = i;
            int r = res.size() - 1;
            int t = target - res.get(i);
            while (l <= r) {
                if (res.get(l) + res.get(r) > t) {
                    r--;
                } else if (res.get(l) + res.get(r) < t) {
                    l++;
                } else {
                    if (i != l && l != r) {
                        result += count[res.get(i)] * count[res.get(l)] * count[res.get(r)];
                    } else if (i == l && l != r) {
                        if (count[res.get(l)] >= 2) {
                            result += count[res.get(l)] * (count[res.get(l)] - 1) / 2 * count[res.get(r)];
                        }
                    } else if (i != l && l == r) {
                        if (count[res.get(r)] >= 2) {
                            result += count[res.get(r)] * (count[res.get(r)] - 1) / 2 * count[res.get(i)];
                        }
                    } else {
                        if (count[res.get(i)] >= 3) {
                            result += count[res.get(i)] * (count[res.get(i)] - 1) * (count[res.get(i)] - 2) / 6;
                        }
                    }
                    l++;
                    result %= mod;
                }
            }
        }
        return (int) (result % mod);
    }

}
