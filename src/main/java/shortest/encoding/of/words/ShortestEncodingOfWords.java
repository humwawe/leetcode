package shortest.encoding.of.words;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class ShortestEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        Set<String> set = new HashSet<>();
        int result = 0;
        for (String word : words) {
            if (!set.contains(word)) {
                result += word.length() + 1;
                for (int i = 0; i < word.length(); i++) {
                    set.add(word.substring(i));
                }
            }
        }
        return result;
    }
}
