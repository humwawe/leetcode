package count.common.words.with.one.occurrence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (String s : words1) {
            if (map1.getOrDefault(s, 0) == 1 && map2.getOrDefault(s, 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
