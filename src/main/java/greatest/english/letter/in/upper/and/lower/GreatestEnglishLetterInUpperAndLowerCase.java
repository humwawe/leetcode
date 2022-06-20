package greatest.english.letter.in.upper.and.lower;

/**
 * @author hum
 */
public class GreatestEnglishLetterInUpperAndLowerCase {
  public String greatestLetter(String s) {
    int[][] cnt = new int[26][2];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if ('a' <= c && c <= 'z') {
        cnt[c - 'a'][0]++;
      }
      if ('A' <= c && c <= 'Z') {
        cnt[c - 'A'][1]++;
      }
    }
    String res = "";
    for (int i = 0; i < 26; i++) {
      if (cnt[i][0] > 0 && cnt[i][1] > 0) {
        res = String.valueOf((char) (i + 'A'));
      }
    }
    return res;
  }
}
