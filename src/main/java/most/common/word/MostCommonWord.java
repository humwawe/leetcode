package most.common.word;

import java.util.*;

/**
 * @author hum
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("!|\\?|'|,|;|\\.", " ");
        System.out.println(paragraph);
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        String[] split = paragraph.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        System.out.println(map);
        int max = 0;
        String result = "";
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
                result = s;
            }
        }
        return result;
    }
}
