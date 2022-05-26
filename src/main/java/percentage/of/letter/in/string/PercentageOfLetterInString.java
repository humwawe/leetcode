package percentage.of.letter.in.string;

/**
 * @author hum
 */
public class PercentageOfLetterInString {
  public int percentageLetter(String s, char letter) {
    int cnt = 0;
    for (char c : s.toCharArray()) {
      if (c == letter) {
        cnt++;
      }
    }
    return cnt * 100 / s.length();
  }
}
