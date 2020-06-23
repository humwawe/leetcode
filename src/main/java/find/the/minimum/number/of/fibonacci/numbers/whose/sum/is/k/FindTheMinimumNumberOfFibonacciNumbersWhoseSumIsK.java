package find.the.minimum.number.of.fibonacci.numbers.whose.sum.is.k;

/**
 * @author hum
 */
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public int findMinFibonacciNumbers(int k) {
        int i, ans = 0;
        int[] f = new int[45];
        for (f[1] = 1, i = 2; i < 45; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        for (i = 44; i > 0; i--) {
            if (k >= f[i]) {
                k -= f[i];
                ans++;
            }
        }
        return ans;
    }
}
