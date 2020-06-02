package prime.arrangements;

/**
 * @author hum
 */
public class PrimeArrangements {
    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!helper(i)) {
                count++;
            }
        }
        int mod = (int) (1e9 + 7);
        long result = 1;
        System.out.println(count);
        for (int i = 1; i <= count; i++) {
            result = (result * i) % mod;
        }
        for (int i = 1; i <= n - count; i++) {
            result = (result * i) % mod;
        }
        return (int) (result % mod);
    }

    private boolean helper(int i) {
        if (i == 1) {
            return false;
        }
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
