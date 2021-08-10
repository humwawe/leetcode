package check.string.is.a.prefix.of.array;

/**
 * @author hum
 */
public class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
