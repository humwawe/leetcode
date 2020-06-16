package decrypt.string.from.alphabet.to.integer.mapping;

/**
 * @author hum
 */
public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        int len = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                int t = (s.charAt(i - 2) - '0') * 10;
                t += s.charAt(i - 1) - '0';
                stringBuilder.append((char) (t - 1 + 'a'));
                i -= 2;
            } else {
                stringBuilder.append((char) (s.charAt(i) - '1' + 'a'));
            }
        }
        return stringBuilder.reverse().toString();
    }
}
