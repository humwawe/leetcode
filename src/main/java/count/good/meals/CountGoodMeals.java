package count.good.meals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int tmp = 1;
        set.add(tmp);
        for (int i = 0; i <= 20; i++) {
            tmp *= 2;
            set.add(tmp);
        }
        long res = 0;
        int mod = (int) (1e9 + 7);
        for (int i : deliciousness) {
            for (Integer integer : set) {
                if (i <= integer) {
                    res += map.getOrDefault(integer - i, 0);
                    res %= mod;
                }
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return (int) res % mod;
    }
}
