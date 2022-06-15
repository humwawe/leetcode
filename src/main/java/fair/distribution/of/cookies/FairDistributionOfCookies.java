package fair.distribution.of.cookies;

/**
 * @author hum
 */
public class FairDistributionOfCookies {
  int[] c;
  int[] cnt;
  int k;
  int ans = (int) 1e9;

  public int distributeCookies(int[] cookies, int k) {
    this.c = cookies;
    this.k = k;
    cnt = new int[k];
    dfs(0, 0);
    return ans;
  }

  private void dfs(int i, int s) {
    if (i == c.length) {
      int max = 0;
      for (int j = 0; j < k; j++) {
        max = Math.max(max, cnt[j]);
      }
      ans = Math.min(ans, max);
      return;
    }

    for (int j = 0; j < s; j++) {
      cnt[j] += c[i];
      dfs(i + 1, s);
      cnt[j] -= c[i];
    }
    if (s < k) {
      cnt[s] += c[i];
      dfs(i + 1, s + 1);
      cnt[s] -= c[i];
    }
  }
}
