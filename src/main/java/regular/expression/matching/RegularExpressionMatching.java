package regular.expression.matching;

/**
 * @author hum
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            if (s.length() == 0) {
                return false;
            }
            return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ? isMatch(s.substring(1), p.substring(1)) : false;
        }
        // 第二个元素为*的时候，对s遍历，递归匹配
        if (p.charAt(1) == '*') {
            int i = 0;
            while (i <= s.length() && (i == 0 || s.charAt(i - 1) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return isMatch(s.substring(i - 1), p.substring(2));
        }
        if (s.length() == 0) {
            return false;
        }
        return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') ? isMatch(s.substring(1), p.substring(1)) : false;
    }
}
