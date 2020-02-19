package consecutive.numbers.sum;

/**
 * @author hum
 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int result = 0;
        int a;
        int b;
        for (int i = 2; i < n; i++) {
            a = n / i;
            b = n % i;
            if (i % 2 == 0) {
                if (a * 2 >= i && b * 2 == i) {
                    result++;
                }
            } else {
                if (a * 2 >= i && b == 0) {
                    result++;
                }
            }
            if (a * 2 < i) {
                break;
            }
        }
        return result;
    }
}
