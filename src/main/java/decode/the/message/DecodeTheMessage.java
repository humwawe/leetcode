package decode.the.message;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class DecodeTheMessage {
  public String decodeMessage(String a, String b) {
    char ch = 'a';
    Map<Character, Character> map = new HashMap<>();
    map.put(' ', ' ');

    for (int i = 0; i < a.length(); i++) {
      if (!map.containsKey(a.charAt(i))) {
        map.put(a.charAt(i), ch++);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < b.length(); i++) {
      sb.append(map.get(b.charAt(i)));
    }
    return sb.toString();
  }
}
