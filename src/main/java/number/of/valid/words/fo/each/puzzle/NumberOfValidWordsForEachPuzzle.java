package number.of.valid.words.fo.each.puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class NumberOfValidWordsForEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int k = 0;
            for (char c : word.toCharArray()) {
                k |= 1 << c - 'a';
            }
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int k = 0;
            for (char c : puzzle.toCharArray()) {
                k |= 1 << c - 'a';
            }
            int count = 0;
            for (int i = k; i > 0; i = (i - 1) & k) {
                if (((1 << (puzzle.charAt(0) - 'a')) & i) != 0) {
                    count += map.getOrDefault(i, 0);
                }
            }
            result.add(count);
        }
        return result;
    }
}
