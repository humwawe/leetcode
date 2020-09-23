package make.sum.divisible.by.p;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        long rest = sum % p;
        if (rest == 0) {
            return 0;
        }
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int res = Integer.MAX_VALUE;
        sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            long need = (sum - rest + p) % p;
            if (map.containsKey(need)) {
                res = Math.min(res, i - map.get(need));
            }
            map.put(sum % p, i);
        }
        if (res == len) {
            return -1;
        }
        return res;
    }
}
