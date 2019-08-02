package ugly.number.III;

/**
 * @author hum
 */
public class UglyNumberIII {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] result = new int[n];
        result[0] = 1;
        int len = primes.length;
        int[] index = new int[len];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, result[index[j]] * primes[j]);
            }
            result[i] = min;
            for (int j = 0; j < len; j++) {
                if (min == result[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }

        return result[n - 1];
    }
}
