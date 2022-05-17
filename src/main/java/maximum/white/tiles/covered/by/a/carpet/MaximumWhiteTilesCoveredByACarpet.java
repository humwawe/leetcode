package maximum.white.tiles.covered.by.a.carpet;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class MaximumWhiteTilesCoveredByACarpet {
  public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
    Arrays.sort(tiles, Comparator.comparingInt(x -> x[0]));
    int len = tiles.length;
    int j = -1;
    int cover = 0;
    int res = 0;
    for (int i = 0; i < len; i++) {
      int start = tiles[i][0];
      while (j + 1 < len && start + carpetLen - 1 >= tiles[j + 1][1]) {
        j++;
        cover += tiles[j][1] - tiles[j][0] + 1;
      }
      int tmp = cover;
      if (j + 1 < len && start + carpetLen - 1 >= tiles[j + 1][0]) {
        tmp += start + carpetLen - tiles[j + 1][0];
      }
      res = Math.max(res, tmp);
      cover -= tiles[i][1] - tiles[i][0] + 1;
    }
    return res;
  }
}
