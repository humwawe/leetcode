package first.letter.to.appear.twice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class FirstLetterToAppearTwice {
  public char repeatedCharacter(String s) {
    Set<Character> set = new HashSet<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      if (!set.add(s.charAt(i))) {
        return s.charAt(i);
      }
    }
    return ' ';
  }

}
