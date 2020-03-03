package prime.palindrome;

/**
 * @author hum
 */
public class PrimePalindrome {
    public int primePalindrome(int n) {
        while (true) {
            if (n == reverse(n) && isPrime(n)) {
                return n;
            }
            n++;
            if (10_000_000 < n && n < 100_000_000) {
                n = 100_000_000;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int r = (int) Math.sqrt(n);
        for (int d = 2; d <= r; ++d) {
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    public int reverse(int n) {
        int ans = 0;
        while (n > 0) {
            ans = 10 * ans + (n % 10);
            n /= 10;
        }
        return ans;
    }
}
