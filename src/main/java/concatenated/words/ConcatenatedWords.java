package concatenated.words;

import java.util.*;

/**
 * @author hum
 */
public class ConcatenatedWords {
    private Set<String> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set.addAll(Arrays.asList(words));
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (helper(word, 0, 0)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean helper(String word, int index, int count) {
        if (index == word.length()) {
            return count > 1;
        }
        for (int i = index; i < word.length(); i++) {
            if (set.contains(word.substring(index, i + 1))) {
                if (helper(word, i + 1, count + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
