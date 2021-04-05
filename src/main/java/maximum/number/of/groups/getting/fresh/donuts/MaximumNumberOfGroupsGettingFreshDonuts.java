package maximum.number.of.groups.getting.fresh.donuts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MaximumNumberOfGroupsGettingFreshDonuts {
    int len;
    int size;
    Map<Integer, Integer> memo = new HashMap<>();

    public int maxHappyGroups(int batchSize, int[] groups) {
        len = groups.length;
        size = batchSize;
        int tmp = 0;
        int[] cnt = new int[batchSize];
        for (int i = 0; i < len; i++) {
            groups[i] %= batchSize;
            if (groups[i] == 0) {
                tmp++;
            } else {
                cnt[groups[i]]++;
            }
        }
        return helper(0, cnt) + tmp;
    }

    private int helper(int mod, int[] cnt) {
        int key = Arrays.hashCode(cnt);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int res = 0;
        for (int i = 1; i < size; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            cnt[i]--;
            int tmp = 0;
            if (mod == 0) {
                tmp = 1;
            }
            res = Math.max(res, helper((mod + i) % size, cnt) + tmp);
            cnt[i]++;
        }
        memo.put(key, res);
        return res;
    }

    private long toKey(int[] cnt) {
        long res = 0;
        for (int i = 1; i < size; i++) {
            res = res * 32 + cnt[i];
        }
        return res;
    }
}
