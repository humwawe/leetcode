package string.matching.in.an.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        int len = words.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (words[i].contains(words[j])) {
                    set.add(words[j]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
