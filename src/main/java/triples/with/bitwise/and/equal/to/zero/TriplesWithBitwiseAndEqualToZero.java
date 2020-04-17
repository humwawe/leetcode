package triples.with.bitwise.and.equal.to.zero;

/**
 * @author hum
 */
public class TriplesWithBitwiseAndEqualToZero {
    public int countTriplets(int[] a) {
        int max = -1;
        for (int i : a) {
            max = Math.max(i, max);
        }
        int[] count = new int[max + 5];
        for (int i : a) {
            for (int j : a) {
                count[i & j]++;
            }
        }
        int result = 0;
        for (int j = 0; j < count.length; j++) {
            if (count[j] == 0) {
                continue;
            }
            for (int i : a) {
                if ((i & j) == 0) {
                    result += count[j];
                }
            }
        }
        return result;
    }
}
