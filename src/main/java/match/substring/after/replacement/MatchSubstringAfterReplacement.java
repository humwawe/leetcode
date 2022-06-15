package match.substring.after.replacement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hum
 */
public class MatchSubstringAfterReplacement {
  public boolean matchReplacement(String s, String sub, char[][] mappings) {
    Map<Character, Set<Character>> map = new HashMap<>();
    for (char[] mapping : mappings) {
      map.computeIfAbsent(mapping[0], x -> new HashSet<>()).add(mapping[1]);
    }
    int len = sub.length();
    for (int i = 0; i + len <= s.length(); i++) {

      if (check(s, i, sub, map)) {
        return true;
      }

    }
    return false;

  }

  private boolean check(String s, int start, String sub, Map<Character, Set<Character>> map) {
    int len = sub.length();
    int j = 0;
    for (int i = start; i < start + len; i++) {
      if (s.charAt(i) == sub.charAt(j)) {
        j++;
      } else {
        Set<Character> set = map.get(sub.charAt(j));
        if (set != null && set.contains(s.charAt(i))) {
          j++;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}
