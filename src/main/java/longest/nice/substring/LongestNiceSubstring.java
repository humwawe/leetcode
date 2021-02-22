package longest.nice.substring;

/**
 * @author hum
 */
public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int len = s.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            int a = 0;
            int b = 0;
            for (int j = i; j < len; j++) {
                char c = s.charAt(j);
                if (Character.isLowerCase(c)) {
                    a |= 1 << c - 'a';
                } else {
                    b |= 1 << c - 'A';
                }
                if (a == b && s.substring(i, j + 1).length() > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
