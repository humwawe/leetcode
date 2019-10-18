package sort.characters.by.frequency;

import java.util.*;

/**
 * @author hum
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            int count = list.get(i).getValue();
            while (count-- > 0) {
                stringBuilder.append(list.get(i).getKey());
            }
        }
        return stringBuilder.toString();
    }
}
