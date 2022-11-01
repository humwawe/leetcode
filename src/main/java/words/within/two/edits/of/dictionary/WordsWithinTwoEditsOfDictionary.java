package words.within.two.edits.of.dictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class WordsWithinTwoEditsOfDictionary {
  public List<String> twoEditWords(String[] queries, String[] dictionary) {
    List<String> list = new ArrayList<>();
    f:
    for (String query : queries) {
      for (String s : dictionary) {
        if (check(query, s)) {
          list.add(query);
          continue f;
        }
      }
    }
    return list;
  }

  private boolean check(String a, String b) {
    int cnt = 0;
    for (int i = 0; i < b.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) {
        cnt++;
      }
    }
    return cnt <= 2;
  }
}
