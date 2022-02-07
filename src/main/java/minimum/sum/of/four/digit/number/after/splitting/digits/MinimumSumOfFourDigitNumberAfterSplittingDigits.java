package minimum.sum.of.four.digit.number.after.splitting.digits;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author hum
 */
public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        list.sort(Comparator.comparingInt(x -> x));
        return list.get(0) * 10 + list.get(1) * 10 + list.get(2) + list.get(3);

    }
}
