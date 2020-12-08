package substring.with.concatenation.of.all.words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author hum
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s == "") {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();

        int len = words[0].length();
        int sumLen = words.length * len;
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                int count = map.get(word);
                map.put(word, count + 1);
            }
        }

        for (int i = 0; i <= s.length() - sumLen; i++) {
            HashMap<String, Integer> mapCopy = new HashMap<>(map);
            String str = s.substring(i, i + sumLen);
            for (int j = 0; j < sumLen; j += len) {
                String word = str.substring(j, j + len);
                if (mapCopy.containsKey(word) && mapCopy.get(word) > 0) {
                    mapCopy.put(word, mapCopy.get(word) - 1);
                    if (mapCopy.get(word) == 0) {
                        mapCopy.remove(word);
                    }
                } else {
                    break;
                }
            }
            if (mapCopy.size() == 0) {
                result.add(i);
            }
        }
        return result;

    }

}
