package minimum.one.bit.operations.to.make.integers.zero;

/**
 * @author hum
 */
public class MinimumOneBitOperationsToMakeIntegersZero {
    public int minimumOneBitOperations(int n) {
        int res = 0;
        while (n > 0) {
            res ^= n;
            n /= 2;
        }
        return res;
    }
}
