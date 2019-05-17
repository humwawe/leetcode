package plus.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hum
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new LinkedList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int unit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            result.add(0, unit);
        }
        if (carry == 1) {
            result.add(0, 1);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
