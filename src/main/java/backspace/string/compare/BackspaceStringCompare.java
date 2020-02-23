package backspace.string.compare;

/**
 * @author hum
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return helper(s).equals(helper(t));
    }

    private String helper(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    res.insert(0, s.charAt(i));
                }
            }
        }
        return res.toString();
    }
}
