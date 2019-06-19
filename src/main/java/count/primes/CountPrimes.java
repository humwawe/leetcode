package count.primes;

import java.util.BitSet;

/**
 * @author hum
 */
public class CountPrimes {
    public static int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        BitSet bitSet = new BitSet(n);
        bitSet.flip(0, n);
        for (int j = 2; j * 2 < n; j++) {
            bitSet.set(2 * j, false);
        }
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            if (bitSet.get(i)) {
                for (int j = 2; j * i < n; j++) {
                    bitSet.set(i * j, false);
                }
            }
        }
        return bitSet.cardinality() - 2;
    }
}
