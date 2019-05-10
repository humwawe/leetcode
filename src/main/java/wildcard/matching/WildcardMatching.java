package wildcard.matching;


/**
 * @author hum
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
        result[0][0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            result[i][0] = false;
        }
        for (int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            } else {
                result[0][i] = true;
            }
        }
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    result[i][j] = result[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    result[i][j] = result[i - 1][j] || result[i][j - 1];
                } else {
                    result[i][j] = false;
                }

            }
        }
        return result[s.length()][p.length()];
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
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            if (helper1(s.substring(1), p.substring(1), result)) {
                result[i][j] = 1;
            } else {
                result[i][j] = -1;
            }
            return result[i][j] == 1;
        }
        if (p.charAt(0) == '*') {
            if (helper1(s.substring(1), p, result) || helper1(s, p.substring(1), result)) {
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
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return helper(s.substring(1), p.substring(1));
        }
        if (p.charAt(0) == '*') {
            return helper(s.substring(1), p) || helper(s, p.substring(1));
        }
        return false;
    }

}
