package hamming.distance;

/**
 * @author hum
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int result = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                result++;
            }
            x >>= 1;
            y >>= 1;
        }
        return result;
    }
}
