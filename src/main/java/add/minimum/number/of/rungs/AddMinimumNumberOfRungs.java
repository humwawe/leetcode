package add.minimum.number.of.rungs;

/**
 * @author hum
 */
public class AddMinimumNumberOfRungs {
    public int addRungs(int[] rungs, int dist) {
        int res = (rungs[0] - 1) / dist;
        for (int i = 1; i < rungs.length; i++) {
            res += (rungs[i] - rungs[i - 1] - 1) / dist;
        }
        return res;
    }
}
