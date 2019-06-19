package happy.number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int tmp = helper(n);
            if (tmp == 1) {
                return true;
            }
            if (set.contains(tmp)) {
                return false;
            } else {
                set.add(tmp);
            }
            n = tmp;
        }
    }

    private int helper(int n) {
        int sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;
    }
}
