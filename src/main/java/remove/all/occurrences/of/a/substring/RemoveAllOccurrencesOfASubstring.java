package remove.all.occurrences.of.a.substring;

/**
 * @author hum
 */
public class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {
        int len = part.length();
        while (true) {
            int i = s.indexOf(part);
            if (i == -1) {
                return s;
            }
            s = s.substring(0, i) + s.substring(i + len);
        }
    }
}
