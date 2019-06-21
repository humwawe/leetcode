package add.and.search.word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class AddAndSearchWord {
    private Map<Integer, Set<String>> map;

    public AddAndSearchWord() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int len = word.length();
        if (map.containsKey(len)) {
            map.get(len).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(len, set);
        }
    }

    public boolean search(String word) {
        int len = word.length();
        if (!map.containsKey(len)) {
            return false;
        }
        Set<String> set = map.get(len);
        if (set.contains(word)) {
            return true;
        }
        for (String s : set) {
            if (isMatch(s, word)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(String s, String word) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }
}
