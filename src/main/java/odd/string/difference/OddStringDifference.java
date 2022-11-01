package odd.string.difference;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class OddStringDifference {
  public String oddString(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    Map<String, String> map2 = new HashMap<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length() - 1; i++) {
        sb.append(word.charAt(i + 1) - word.charAt(i));
        sb.append("|");
      }
      map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
      map2.put(sb.toString(), word);
    }
    for (String s : map.keySet()) {
      if (map.get(s) == 1) {
        return map2.get(s);
      }
    }
    return "";
  }
}
