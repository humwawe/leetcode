package number.of.ways.to.select.buildings;

/**
 * @author hum
 */
public class NumberOfWaysToSelectBuildings {
  public long numberOfWays(String s) {
    char[] chars = s.toCharArray();
    char[] char1 = {'0', '1', '0'};
    char[] char2 = {'1', '0', '1'};

    return helper(chars, char1) + helper(chars, char2);
  }

  public long helper(char[] chars, char[] goal) {
    long a1 = 0, a2 = 0, a3 = 0;
    for (char c : chars) {
      if (c == goal[0]) {
        a1++;
      }
      if (c == goal[1]) {
        a2 += a1;
      }
      if (c == goal[2]) {
        a3 += a2;
      }
    }
    return a3;
  }
}
