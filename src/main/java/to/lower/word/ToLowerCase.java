package to.lower.word;

/**
 * @author hum
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                stringBuilder.append((char) (c - 'A' + 'a'));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
