package largest.multiple.of.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class LargestMultipleOfThree {
    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        Arrays.sort(digits);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            stringBuilder.append(digit);
            sum += digit;
            if (digit % 3 == 1) {
                list1.add(i);
            }
            if (digit % 3 == 2) {
                list2.add(i);
            }
        }
        if (sum % 3 == 0) {
            if (stringBuilder.charAt(0) == '0' && stringBuilder.charAt(stringBuilder.length() - 1) == '0') {
                return "0";
            }
            return stringBuilder.reverse().toString();
        }
        if (sum % 3 == 1) {
            if (list1.size() > 0) {
                stringBuilder.deleteCharAt(list1.get(0));
                return stringBuilder.reverse().toString();
            } else {
                stringBuilder.deleteCharAt(list2.get(1));
                stringBuilder.deleteCharAt(list2.get(0));
                return stringBuilder.reverse().toString();
            }
        } else {
            if (list2.size() > 0) {
                stringBuilder.deleteCharAt(list2.get(0));
                return stringBuilder.reverse().toString();
            } else {
                stringBuilder.deleteCharAt(list1.get(1));
                stringBuilder.deleteCharAt(list1.get(0));
                return stringBuilder.reverse().toString();
            }
        }
    }
}
