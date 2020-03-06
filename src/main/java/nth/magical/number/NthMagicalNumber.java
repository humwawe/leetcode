package nth.magical.number;

/**
 * @author hum
 */
public class NthMagicalNumber {
    public int nthMagicalNumber(int n, int a, int b) {
        int t = a * b / gcd(a, b);
        int mod = (int) 1e9 + 7;
        int num = t / a + t / b - 1;
        int i = (n - 1) / num;
        int j = (n - 1) % num;
        long result = (long) t * i + Math.min(a, b);
        if (j == 0) {
            return (int) (result % mod);
        }
        long index1 = 1;
        long index2 = 1;
        result = (long) t * i;
        long tmp = 0;
        while (j >= 0) {
            long t1 = a * index1;
            long t2 = b * index2;
            tmp = Math.min(t1, t2);
            if (t1 < t2) {
                index1++;
            } else {
                index2++;
            }
            j--;
        }
        return (int) ((result + tmp) % mod);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
