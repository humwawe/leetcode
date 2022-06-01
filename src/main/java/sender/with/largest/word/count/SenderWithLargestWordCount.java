package sender.with.largest.word.count;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class SenderWithLargestWordCount {
  public String largestWordCount(String[] messages, String[] senders) {
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < senders.length; i++) {
      String[] s = messages[i].split(" ");

      map.put(senders[i], map.getOrDefault(senders[i], 0) + s.length);

    }
    int max = 0;
    String res = "";
    for (String s : map.keySet()) {
      if (map.get(s) > max) {
        res = s;
        max = map.get(s);
      } else if (map.get(s) == max) {
        if (s.compareTo(res) > 0) {
          res = s;
        }
      }
    }
    return res;
  }
}
