package ugly.number.IIII;

/**
 * @author hum
 */
public class UglyNumberIIII {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(ab, c);
        long left = 0;
        long righ = 2000000000;
        while (left < righ) {
            long mid = left + (righ - left) / 2;
            long count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n) {
                righ = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    long gcd(long a, long b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
