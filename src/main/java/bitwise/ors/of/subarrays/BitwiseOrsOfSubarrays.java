package bitwise.ors.of.subarrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class BitwiseOrsOfSubarrays {
    public int subarrayBitwiseORs(int[] a) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for (int x : a) {
            Set<Integer> next = new HashSet<>();
            for (int y : cur) {
                next.add(x | y);
            }
            next.add(x);
            cur = next;
            result.addAll(cur);
        }
        return result.size();
    }
}
