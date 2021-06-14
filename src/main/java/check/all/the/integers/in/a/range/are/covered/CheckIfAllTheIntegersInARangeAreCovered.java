package check.all.the.integers.in.a.range.are.covered;

/**
 * @author hum
 */
public class CheckIfAllTheIntegersInARangeAreCovered {
    public boolean isCovered(int[][] ranges, int left, int right) {
        f:
        for (int i = left; i <= right; i++) {
            for (int[] range : ranges) {
                if (range[0] <= i && range[1] >= i) {
                    continue f;
                }
            }
            return false;
        }
        return true;
    }
}
