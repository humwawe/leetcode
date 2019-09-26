package nth.digit;

/**
 * @author hum
 */
public class NthDigit {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int i = 1;
        long count = 9;
        while (i < 20) {
            if (n > i * count) {
                n -= i * count;
            } else {
                break;
            }
            count *= 10;
            i++;
        }

        int tmp = n / i;
        int t = n % i;
        int base = (int) Math.pow(10, (i - 1));
        int num = base + tmp - 1;
        if (t == 0) {
            return num % 10;
        } else {
            return String.valueOf(num + 1).charAt(t - 1) - '0';
        }
    }
}
