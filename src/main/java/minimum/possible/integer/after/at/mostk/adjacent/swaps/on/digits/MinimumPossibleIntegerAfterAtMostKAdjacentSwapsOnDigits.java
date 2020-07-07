package minimum.possible.integer.after.at.mostk.adjacent.swaps.on.digits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits {
    int[] t = new int[300005];
    int n;

    public String minInteger(String num, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, new ArrayList<>());
        }
        int len = num.length();
        n = len;
        for (int i = 0; i < len; i++) {
            map.get(num.charAt(i) - '0').add(i + 1);
        }
        int[] idx = new int[10];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                if (idx[j] >= map.get(j).size()) {
                    continue;
                }
                int p = map.get(j).get(idx[j]);
                int step = p - 1 - sum(p);
                if (step <= k) {
                    k -= step;
                    add(p, 1);
                    stringBuilder.append((char) (j + '0'));
                    idx[j]++;
                    break;
                }
            }
        }
        return stringBuilder.toString();

    }

    int lowbit(int x) {
        return x & -x;
    }

    void add(int x, int c) {
        for (int i = x; i <= n; i += lowbit(i)) {
            t[i] += c;
        }
    }

    int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += t[i];
        }
        return res;
    }
}
