package remove.letter.to.equalize.frequency;

/**
 * @author hum
 */
public class RemoveLetterToEqualizeFrequency {
  public boolean equalFrequency(String word) {
    int[] map = new int[26];
    for (char c : word.toCharArray()) {
      map[c - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      map[i]--;
      if (map[i] != -1 && checkFrequency(map)) {
        return true;
      }
      map[i]++;
    }
    return false;
  }

  boolean checkFrequency(int[] a) {
    int pre = -1;
    for (int i = 0; i < 26; i++) {
      if (pre == -1 && a[i] != 0) {
        pre = a[i];
      }
      if (a[i] != 0 && a[i] != pre) {
        return false;
      }
    }
    return true;
  }
}
