package count.prefixes.of.a.given.string;

/**
 * @author hum
 */
public class CountPrefixesOfAGivenString {
  public int countPrefixes(String[] words, String s) {
    int res = 0;
    for (String word : words) {
      if (s.startsWith(word)) {
        res++;
      }
    }
    return res;
  }
}
