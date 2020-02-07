package unique.morse.code.words;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder tmp = new StringBuilder();
            for (char c : word.toCharArray()) {
                tmp.append(map[c - 'a']);
            }
            set.add(tmp.toString());
        }
        return set.size();
    }
}
