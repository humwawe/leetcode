package bulb.switcher.III;

/**
 * @author hum
 */
public class BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        int len = light.length;
        int end = 0;
        int result = 0;
        for (int i = 1; i <= len; i++) {
            end = Math.max(end, light[i - 1]);
            if (i == end) {
                result++;
            }
        }
        return result;
    }
}
