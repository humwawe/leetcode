package prime.number.of.set.bits.in.binary.representation;

/**
 * @author hum
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int l, int r) {
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        int result = 0;
        for (int i = l; i <= r; i++) {
            int count = Integer.bitCount(i);
            result += primes[count];
        }
        return result;
    }
}
