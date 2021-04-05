package minimum.number.of.operations.to.reinitialize.a.permutation;

/**
 * @author hum
 */
public class MinimumNumberOfOperationsToReinitializeAPermutation {
    public int reinitializePermutation(int n) {
        int idx = 1;
        int step = 0;
        do {
            if (idx % 2 == 0) {
                idx = idx / 2;
            } else {
                idx = n / 2 + (idx - 1) / 2;
            }
            step++;
        } while (idx != 1);
        return step;
    }
}
