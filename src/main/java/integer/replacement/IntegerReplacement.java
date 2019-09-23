package integer.replacement;

/**
 * @author hum
 */
public class IntegerReplacement {
    public int integerReplacement(int n) {
        return (int) helper(n);

    }

    private long helper(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + helper(n / 2);

        } else {
            return Math.min(helper(n + 1), helper(n - 1)) + 1;
        }
    }
}
