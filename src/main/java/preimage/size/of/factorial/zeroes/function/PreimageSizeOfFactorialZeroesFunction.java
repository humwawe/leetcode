package preimage.size.of.factorial.zeroes.function;

/**
 * @author hum
 */
public class PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int k) {
        long left = 0;
        long right = 5L * (k + 1);
        while (left < right) {
            long mid = left + (right - left) / 2;
            int count = numOfTrailingZeros(mid);
            if (count == k) {
                return 5;
            } else if (count > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    private int numOfTrailingZeros(long x) {
        int res = 0;
        while (x > 0) {
            res += x / 5;
            x = x / 5;
        }
        return res;
    }
}
