package check.distances.between.same.letters;

import java.util.Arrays;

/**
 * @author hum
 */
public class CheckDistancesBetweenSameLetters {
  public boolean checkDistances(String s, int[] distance) {
    int[] last = new int[26];
    Arrays.fill(last, -1);
    int len = s.length();
    for (int i = 0; i < len; i++) {
      char c = s.charAt(i);
      if (last[c - 'a'] == -1) {
        last[c - 'a'] = i;
      } else {
        if (distance[c - 'a'] != i - last[c - 'a'] - 1) {
          return false;
        }
      }
    }
    return true;
  }
}
