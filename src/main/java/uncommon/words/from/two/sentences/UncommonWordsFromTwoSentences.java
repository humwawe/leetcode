package uncommon.words.from.two.sentences;

import java.util.*;

/**
 * @author hum
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String a, String b) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : a.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : b.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                list.add(item.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
