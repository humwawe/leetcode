package minimum.swaps.to.make.strings.equal;

/**
 * @author hum
 */
public class MinimumSwapsToMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        int x = 0;
        int y = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    x++;
                } else {
                    y++;
                }
            }
        }
        if ((x + y) % 2 != 0) {
            return -1;
        }
        if (x % 2 == 0) {
            return (x + y) / 2;
        }
        return (x - 1 + y - 1) / 2 + 2;
    }
}