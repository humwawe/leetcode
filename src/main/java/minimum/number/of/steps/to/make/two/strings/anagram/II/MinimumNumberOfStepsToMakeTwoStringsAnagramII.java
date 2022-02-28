package minimum.number.of.steps.to.make.two.strings.anagram.II;

/**
 * @author hum
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagramII {
  public int minSteps(String s, String t) {
    int[] ca = new int[26];
    int[] cb = new int[26];
    for (char c : s.toCharArray()) {
      ca[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      cb[c - 'a']++;
    }
    int res = 0;
    for (int i = 0; i < 26; i++) {
      res += Math.abs(ca[i] - cb[i]);
    }
    return res;
  }
}
