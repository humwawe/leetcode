package binary.prefix.divisible.by.five;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class BinaryPrefixDivisibleByFive {
    public List<Boolean> prefixesDivBy5(int[] a) {
        List<Boolean> result = new ArrayList<>();
        int tmp = 0;
        for (int i : a) {
            tmp = tmp * 2 + i;
            if (tmp % 5 == 0) {
                result.add(true);
            } else {
                result.add(false);
            }
            tmp %= 5;
        }
        return result;
    }
}
