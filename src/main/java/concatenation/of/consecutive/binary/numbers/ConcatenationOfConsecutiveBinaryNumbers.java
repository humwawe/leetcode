package concatenation.of.consecutive.binary.numbers;

/**
 * @author hum
 */
public class ConcatenationOfConsecutiveBinaryNumbers {
    public int concatenatedBinary(int n) {
        int mod = (int) (1e9 + 7);
        long res = 0;
        int len = 0;
        for (long i = 1; i <= n; i++) {
            len = helper(i);
            res = (res << len) + i;
            res %= mod;
        }
        return (int) res % mod;
    }

    private int helper(long num) {
        int cnt = 0;
        while (num > 0) {
            num >>= 1;
            cnt++;
        }
        return cnt;
    }

}
