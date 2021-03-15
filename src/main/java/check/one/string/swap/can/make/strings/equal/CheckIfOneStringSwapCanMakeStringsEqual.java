package check.one.string.swap.can.make.strings.equal;

/**
 * @author hum
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        int a = -1;
        int b = -1;
        if (s1.equals(s2)) {
            return true;
        }
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                if (a == -1) {
                    a = i;
                } else {
                    b = i;
                }
            }
        }
        if (cnt == 2) {
            return s1.charAt(a) == s2.charAt(b) && s1.charAt(b) == s2.charAt(a);
        }
        return false;
    }
}
