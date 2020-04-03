package fraction.to.recurring.decimal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        int index = 1;
        long tmp1 = numerator;
        long tmp2 = denominator;
        while (true) {
            long first = tmp1 / tmp2;
            long second = tmp1 % tmp2;
            result.append(Math.abs(first));
            if (index == 1) {
                if (second != 0) {
                    result.append(".");
                }
                if ((tmp1 < 0 && tmp2 > 0) || (tmp1 > 0 && tmp2 < 0)) {
                    result.insert(0, "-");
                }
            }
            if (second != 0) {
                if (map.containsKey(second * 10)) {
                    return result.toString().replaceAll("(.{" + (index - map.get(second * 10)) + "}$)", "($1)");
                }
                map.put(second * 10, index);
                index++;
                tmp1 = second * 10;
            } else {
                break;
            }
        }
        return result.toString();
    }
}
