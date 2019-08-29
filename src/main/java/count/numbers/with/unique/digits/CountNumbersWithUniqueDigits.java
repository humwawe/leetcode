package count.numbers.with.unique.digits;

/**
 * @author hum
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int temp = 9;
        int result = 10;
        for (int i = 2; i <= n; i++) {
            temp = temp * (10 - i + 1);
            result += temp;
        }
        return result;
    }
}
