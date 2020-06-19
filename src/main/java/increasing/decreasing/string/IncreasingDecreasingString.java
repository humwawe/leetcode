package increasing.decreasing.string;

/**
 * @author hum
 */
public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] t = new int[26];
        for (char c : s.toCharArray()) {
            t[c - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        while (stringBuilder.length() < len) {
            for (int i = 0; i < 26; i++) {
                if (t[i] > 0) {
                    stringBuilder.append((char) ('a' + i));
                    t[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (t[i] > 0) {
                    stringBuilder.append((char) ('a' + i));
                    t[i]--;
                }
            }
        }
        return stringBuilder.toString();
    }
}
