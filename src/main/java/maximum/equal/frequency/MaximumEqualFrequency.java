package maximum.equal.frequency;

import java.util.TreeMap;

/**
 * @author hum
 */
public class MaximumEqualFrequency {
    public int maxEqualFreq(int[] nums) {
        int[] cnt = new int[100010];
        int res = 2;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] != 1) {
                map.put(cnt[nums[i]] - 1, map.get(cnt[nums[i]] - 1) - 1);
                if (map.get(cnt[nums[i]] - 1) == 0) {
                    map.remove(cnt[nums[i]] - 1);
                }
            }
            map.put(cnt[nums[i]], map.getOrDefault(cnt[nums[i]], 0) + 1);

            if (map.size() == 1) {
                if (map.firstKey() == 1) {
                    res = i + 1;
                } else if (map.firstEntry().getValue() == 1) {
                    res = i + 1;
                }
            } else if (map.size() == 2) {
                if (map.firstKey() == 1 && map.firstEntry().getValue() == 1) {
                    res = i + 1;
                } else if (map.firstKey() + 1 == map.lastKey() && map.lastEntry().getValue() == 1) {
                    res = i + 1;
                }
            }
        }
        return res;
    }
}
