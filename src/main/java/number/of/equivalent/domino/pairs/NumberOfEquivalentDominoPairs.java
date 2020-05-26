package number.of.equivalent.domino.pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            int tmp;
            if (dominoe[0] > dominoe[1]) {
                tmp = dominoe[0] * 10 + dominoe[1];
            } else {
                tmp = dominoe[1] * 10 + dominoe[0];
            }
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        int result = 0;
        for (Integer v : map.values()) {
            if (v > 1) {
                result += v * (v - 1) / 2;
            }
        }
        return result;
    }
}
