package minimize.deviation.in.array;

import java.util.TreeSet;

/**
 * @author hum
 */
public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                set.add(num * 2);
            } else {
                set.add(num);
            }
        }
        int res = set.last() - set.first();
        while (true) {
            res = Math.min(res, set.last() - set.first());
            Integer last = set.pollLast();
            if (last % 2 == 0) {
                set.add(last / 2);
            } else {
                break;
            }
        }
        return res;
    }
}
