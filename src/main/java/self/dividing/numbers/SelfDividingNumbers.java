package self.dividing.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int n = left; n <= right; ++n) {
            if (helper(n)) {
                result.add(n);
            }
        }
        return result;
    }

    private boolean helper(int num) {
        int temp = 0;
        int n = num;
        while (num > 0) {
            temp = num % 10;
            if (temp == 0 || n % temp != 0) {
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
