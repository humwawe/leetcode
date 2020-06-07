package split.a.string.in.balanced.strings;

/**
 * @author hum
 */
public class SplitAStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                balance--;
            } else {
                balance++;
            }
            if (balance == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
