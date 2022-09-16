package optimal.partition.of.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class OptimalPartitionOfString {
  public int partitionString(String s) {
    int res = 1;
    char[] chars = s.toCharArray();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < chars.length; i++) {
      if (set.contains(chars[i])) {
        res++;
        set.clear();
      }
      set.add(chars[i]);
    }
    return res;
  }

}
