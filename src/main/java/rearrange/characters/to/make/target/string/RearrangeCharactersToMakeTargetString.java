package rearrange.characters.to.make.target.string;

/**
 * @author hum
 */
public class RearrangeCharactersToMakeTargetString {
  public int rearrangeCharacters(String s, String target) {
    int[] cnt = new int[26];
    for (char c : s.toCharArray()) {
      cnt[c - 'a']++;
    }
    int[] cnt2 = new int[26];
    for (char c : target.toCharArray()) {
      cnt2[c - 'a']++;
    }

    int min = 10000;
    for (int i = 0; i < 26; i++) {
      if (cnt2[i] != 0) {
        min = Math.min(min, cnt[i] / cnt2[i]);
      }
    }
    return min;
  }
}
