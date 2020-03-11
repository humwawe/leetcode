package find.and.replace.pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (helper(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean helper(String word, String pattern) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);
        for (int i = 0; i < word.length(); i++) {
            int c1 = word.charAt(i);
            int c2 = pattern.charAt(i);
            if (map1[c1 - 'a'] != -1) {
                if (map1[c1 - 'a'] != c2 - 'a') {
                    return false;
                }
            } else {
                map1[c1 - 'a'] = c2 - 'a';
            }
            if (map2[c2 - 'a'] != -1) {
                if (map2[c2 - 'a'] != c1 - 'a') {
                    return false;
                }
            } else {
                map2[c2 - 'a'] = c1 - 'a';
            }
        }
        return true;
    }

}
