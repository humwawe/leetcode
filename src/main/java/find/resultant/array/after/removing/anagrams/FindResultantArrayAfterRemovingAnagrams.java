package find.resultant.array.after.removing.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class FindResultantArrayAfterRemovingAnagrams {
  public List<String> removeAnagrams(String[] words) {
    List<String> ans = new ArrayList<>();
    String last = " ";
    for (int i = 0; i < words.length; ++i) {
      char[] cs = words[i].toCharArray();
      Arrays.sort(cs);
      String s = String.valueOf(cs);
      if (i >= 1 && s.equals(last)) {
        continue;
      }
      ans.add(words[i]);
      last = s;
    }
    return ans;
  }

}
