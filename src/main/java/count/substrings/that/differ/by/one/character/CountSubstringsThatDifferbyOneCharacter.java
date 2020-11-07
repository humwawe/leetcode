package count.substrings.that.differ.by.one.character;

/**
 * @author hum
 */
public class CountSubstringsThatDifferbyOneCharacter {
    public int countSubstrings(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int diff = 0;
                for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        diff += 1;
                    }
                    if (diff == 1) {
                        res += 1;
                    }
                    if (diff > 1) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
