package count.nice.pairs.in.an.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        int mod = (int) (1e9 + 7);
        for (int num : nums) {
            int rev = helper(num);
            int tmp = num - rev;
            if (map.containsKey(tmp)) {
                res = (res + map.get(tmp)) % mod;
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return (int) res % mod;
    }

    private int helper(int num) {
        String s = String.valueOf(num);
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            res = res * 10 + s.charAt(i) - '0';
        }
        return res;
    }
}
