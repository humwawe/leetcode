package sup.palindromes;

/**
 * @author hum
 */
public class SuperPalindromes {
    public int superpalindromesInRange(String l, String r) {
        int result = 0;
        long a = Long.valueOf(l);
        long b = Long.valueOf(r);
        for (int i = 0; i < 1e5; i++) {
            for (int j = 0; j <= 1; j++) {
                long tmp = helper(i, j);
                long superTmp = tmp * tmp;
                if (superTmp >= a && superTmp <= b && reverse(superTmp) == superTmp) {
                    result++;
                }
            }
        }
        return result;
    }

    private long reverse(long n) {
        long ans = 0;
        while (n > 0) {
            ans = 10 * ans + (n % 10);
            n /= 10;
        }
        return ans;
    }

    private long helper(int i, int j) {
        long res = i;
        if (j == 0) {
            i /= 10;
        }
        while (i > 0) {
            res = res * 10 + i % 10;
            i /= 10;
        }
        return res;
    }
}
