package check.a.parentheses.string.can.be.valid;

/**
 * @author hum
 */
public class CheckIfAParenthesesStringCanBeValid {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if (s.length() % 2 != 0) {
            return false;
        }
        int cnt = 0;
        int x = 0;
        for (int i = 0; i < len; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    cnt++;
                } else {
                    cnt--;
                }
            } else {
                x++;
            }
            if (cnt < 0 && cnt + x < 0) {
                return false;
            }
        }
        cnt = 0;
        x = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    cnt--;
                } else {
                    cnt++;
                }
            } else {
                x++;
            }
            if (cnt < 0 && cnt + x < 0) {
                return false;
            }
        }

        return true;
    }
}
