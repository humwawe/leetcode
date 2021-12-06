package finding.three.digit.even.numbers;

import java.util.*;

/**
 * @author hum
 */
public class FindingThreeDigitEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int len = digits.length;
        for (int i = 0; i < len; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (i == j || k == i || k == j) {
                        continue;
                    }
                    if (digits[k] % 2 != 0) {
                        continue;
                    }
                    set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }
}
