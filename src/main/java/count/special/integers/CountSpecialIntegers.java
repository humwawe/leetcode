package count.special.integers;

/**
 * @author hum
 */
public class CountSpecialIntegers {
  int len = 0;
  int[] num = new int[10];
  Integer[][] memo = new Integer[10][1024 + 10];

  public int countSpecialNumbers(int n) {
    int t = n;
    while (t > 0) {
      num[len++] = t % 10;
      t /= 10;
    }

    return dfs(len - 1, 0, true, true);
  }

  int dfs(int i, int st, boolean limit, boolean lead) {
    // 算到num的最后一位
    if (i == -1) {
      // 考虑能否取 0
      return lead ? 0 : 1;
    }
    if (!limit && !lead && memo[i][st] != null) {
      return memo[i][st];
    }

    int res = 0;
    // 可以跳过当前数位
    if (lead) {
      res = dfs(i - 1, st, false, true);
    }

    int up = limit ? num[i] : 9;
    // 根据前导0判断是否能取到0
    int low = lead ? 1 : 0;

    for (int j = low; j <= up; j++) {
      if ((st >> j & 1) == 0) {
        res += dfs(i - 1, st | (1 << j), limit && j == up, false);
      }
    }
    if (!limit && !lead) {
      memo[i][st] = res;
    }
    return res;
  }

}
