package longest.uploaded.prefix;

/**
 * @author hum
 */
public class LongestUploadedPrefix {
  boolean[] vis;
  int j;
  int n;

  public LongestUploadedPrefix(int n) {
    this.n = n;
    vis = new boolean[n + 2];
    j = 0;
  }

  public void upload(int video) {
    vis[video] = true;
  }

  public int longest() {
    while (j + 1 <= n && vis[j + 1]) {
      j++;
    }
    return j;
  }
}
