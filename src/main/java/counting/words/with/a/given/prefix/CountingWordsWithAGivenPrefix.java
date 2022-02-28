package counting.words.with.a.given.prefix;

/**
 * @author hum
 */
public class CountingWordsWithAGivenPrefix {
  public int prefixCount(String[] words, String pref) {
    int res = 0;
    for (String word : words) {
      if (word.startsWith(pref)) {
        res++;
      }
    }
    return res;
  }
}
