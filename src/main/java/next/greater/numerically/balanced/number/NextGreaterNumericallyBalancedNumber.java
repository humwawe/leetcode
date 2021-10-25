package next.greater.numerically.balanced.number;

/**
 * @author hum
 */
public class NextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (check(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(int i) {
        int[] cnt = new int[10];
        while (i > 0) {
            int a = i % 10;
            i /= 10;
            cnt[a]++;
        }
        for (int j = 0; j < 10; j++) {
            if (cnt[j] == 0) {
                continue;
            }
            if (cnt[j] != j) {
                return false;
            }
        }
        return true;
    }
}
