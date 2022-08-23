package minimum.recolors.to.get.k.consecutive.black.blocks;

/**
 * @author hum
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
  public int minimumRecolors(String blocks, int k) {
    int len = blocks.length();
    int j = 0;
    int cnt = 0;
    int res = len;
    for (int i = 0; i < len; i++) {
      if (blocks.charAt(i) == 'W') {
        cnt++;
      }
      if (i - j + 1 >= k) {
        res = Math.min(res, cnt);
        if (blocks.charAt(j) == 'W') {
          cnt--;
        }
        j++;
      }
    }
    return res;
  }
}
