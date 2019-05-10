package wildcard.matching;


/**
 * @author hum
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        return true;
    }

    public boolean isMatch1(String s, String p) {
        StringBuilder pOther = new StringBuilder();
        int i;
        pOther.append('X');
        for (i = 0; i < p.length(); i++) {
            if (pOther.charAt(pOther.length() - 1) == '*' && p.charAt(i) == '*') {
                continue;
            }
            pOther.append(p.charAt(i));
        }
        p = pOther.toString().substring(1);
        int[][] result = new int[s.length() + 1][p.length() + 1];

        return helper1(s, p, result);
    }


    private boolean helper1(String s, String p, int[][] result) {
        int i = s.length();
        int j = p.length();
        if (result[i][j] != 0) {
            return result[i][j] == 1;
        }
        if (s.equals(p)) {
            result[i][j] = 1;
            return result[i][j] == 1;
        }
        if (s.length() == 0) {
            if (p.equals("*")) {
                result[i][j] = 1;
            } else {
                result[i][j] = -1;
            }
            return result[i][j] == 1;
        }
        if (p.length() == 0) {
            result[i][j] = -1;
            return result[i][j] == 1;
        }
        if (s.charAt(0) == p.charAt(0)) {
            if (helper1(s.substring(1), p.substring(1), result)) {
                result[i][j] = 1;
            } else {
                result[i][j] = -1;
            }
            return result[i][j] == 1;
        }
        if (p.charAt(0) == '?') {
            if (helper1(s.substring(1), p.substring(1), result)) {
                result[i][j] = 1;
            } else {
                result[i][j] = -1;
            }
            return result[i][j] == 1;
        }
        if (p.charAt(0) == '*') {
            if (helper1(s.substring(1), p, result) || helper1(s.substring(1), p.substring(1), result) || helper1(s, p.substring(1), result)) {
                result[i][j] = 1;
            } else {
                result[i][j] = -1;
            }
            return result[i][j] == 1;
        }
        result[i][j] = -1;
        return result[i][j] == 1;
    }

    private boolean helper(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (s.length() == 0) {
            return p.equals("*");

        }
        if (p.length() == 0) {
            return false;
        }
        if (s.charAt(0) == p.charAt(0)) {
            return helper(s.substring(1), p.substring(1));
        }
        if (p.charAt(0) == '?') {
            return helper(s.substring(1), p.substring(1));
        }
        if (p.charAt(0) == '*') {
            return helper(s.substring(1), p) || helper(s, p.substring(1));
        }
        return false;
    }

}
