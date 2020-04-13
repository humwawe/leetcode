package numbers.with.same.consecutive.differences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class NumbersWithSameConsecutiveDifferences {
    List<Integer> list = new ArrayList<>();

    public int[] numsSameConsecDiff(int len, int k) {
        if (len == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        helper(len, k, -1, 0);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void helper(int len, int k, int prev, int sum) {
        if (len == 0) {
            list.add(sum);
            return;
        }
        if (prev == -1) {
            for (int i = 1; i <= 9; i++) {
                helper(len - 1, k, i, sum * 10 + i);
            }
        } else {
            if (prev + k <= 9) {
                helper(len - 1, k, prev + k, sum * 10 + prev + k);
            }
            if (prev - k >= 0 && k != 0) {
                helper(len - 1, k, prev - k, sum * 10 + prev - k);
            }
        }
    }
}
