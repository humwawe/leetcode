package replace.all.digits.with.characters;

/**
 * @author hum
 */
public class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        char[] res = new char[s.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = i % 2 == 0 ? s.charAt(i) : (char) (s.charAt(i - 1) + (s.charAt(i) - '0'));
        }
        return new String(res);
    }

}
