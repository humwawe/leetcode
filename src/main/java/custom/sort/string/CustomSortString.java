package custom.sort.string;

/**
 * @author hum
 */
public class CustomSortString {
    public String customSortString(String s, String t) {
        int[] tmp = new int[26];
        for (char c : t.toCharArray()) {
            tmp[c - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            int count = tmp[c - 'a'];
            if (count != 0) {
                while (count-- > 0) {
                    stringBuilder.append(c);
                }
            }
            tmp[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            int count = tmp[i];
            if (count != 0) {
                while (count-- > 0) {
                    stringBuilder.append((char) (i + 'a'));
                }
            }
        }
        return stringBuilder.toString();
    }
}
