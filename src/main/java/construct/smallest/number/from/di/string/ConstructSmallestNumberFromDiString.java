package construct.smallest.number.from.di.string;

/**
 * @author hum
 */
public class ConstructSmallestNumberFromDiString {
  String pattern;
  StringBuilder ans = new StringBuilder();
  int len;

  public String smallestNumber(String pattern) {
    this.pattern = pattern;
    this.len = pattern.length();

    for (int i = 0; i < 9; i++) {
      if (dfs(1 << i, 0, i)) {
        ans.insert(0, i + 1);
        return ans.toString();
      }
    }
    return "";

  }

  private boolean dfs(int st, int i, int last) {
    if (i == len) {
      return true;
    }
    for (int j = 0; j < 9; j++) {
      if (((st >> j) & 1) != 1) {
        if (pattern.charAt(i) == 'I' && j > last) {
          ans.append(j + 1);
          if (dfs(st | (1 << j), i + 1, j)) {
            return true;
          }
          ans.deleteCharAt(ans.length() - 1);
        } else if (pattern.charAt(i) == 'D' && j < last) {
          ans.append(j + 1);
          if (dfs(st | (1 << j), i + 1, j)) {
            return true;
          }
          ans.deleteCharAt(ans.length() - 1);
        }
      }
    }
    return false;
  }
}
