package pyramid.transition.matrix;

import java.util.*;

/**
 * @author hum
 */
public class PyramidTransitionMatrix {
    Map<String, Set<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String substring = s.substring(0, 2);
            char c = s.charAt(2);
            if (map.containsKey(substring)) {
                map.get(substring).add(c);
            } else {
                Set<Character> tmp = new HashSet<>();
                tmp.add(c);
                map.put(substring, tmp);
            }
        }
        return helper(bottom, 0, "");
    }

    private boolean helper(String bottom, int start, String next) {
        if (bottom.length() == 1) {
            return true;
        }
        if (start == bottom.length() - 1) {
            return helper(next, 0, "");
        }
        String tmp = bottom.substring(start, start + 2);
        for (Character character : map.getOrDefault(tmp, new HashSet<>())) {
            if (helper(bottom, start + 1, "" + character)) {
                return true;
            }
        }
        return false;
    }
}
