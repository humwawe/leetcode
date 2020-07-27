package bulb.switcher.IV;

/**
 * @author hum
 */
public class BulbSwitcherIV {
    public int minFlips(String target) {
        int len = target.length();
        int result = 0;
        int cur = 0;
        for (int i = 0; i < len; i++) {
            if (target.charAt(i) - '0' != cur) {
                result++;
                cur ^= 1;
            }
        }
        return result;
    }
}
