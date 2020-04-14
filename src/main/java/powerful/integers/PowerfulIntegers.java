package powerful.integers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        if (bound < 2) {
            return new ArrayList<>();
        }
        int a, b;
        if (x == 1) {
            a = 1;
        } else {
            a = (int) (Math.log(bound) / Math.log(x)) + 1;
        }
        if (y == 1) {
            b = 1;
        } else {
            b = (int) (Math.log(bound) / Math.log(y)) + 1;
        }
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int tmp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (tmp <= bound) {
                    set.add(tmp);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
