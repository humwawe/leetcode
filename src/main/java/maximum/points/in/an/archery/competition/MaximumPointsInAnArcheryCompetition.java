package maximum.points.in.an.archery.competition;

/**
 * @author hum
 */
public class MaximumPointsInAnArcheryCompetition {
  public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
    int len = aliceArrows.length;
    int lim = 1 << len;
    int[] res = new int[len];
    int max = 0;
    for (int i = lim - 1; i >= 0; i--) {
      int tmp = 0;
      int score = 0;
      for (int j = 0; j < len; j++) {
        if ((i >> j & 1) == 1) {
          tmp += aliceArrows[j] + 1;
          score += j;
        }
      }

      if (tmp <= numArrows) {
        if (score > max) {
          max = score;
          for (int j = 0; j < len; j++) {
            if ((i >> j & 1) == 1) {
              res[j] = aliceArrows[j] + 1;
            } else {
              res[j] = 0;
            }
          }
          res[0] += numArrows - tmp;
        }
      }
    }
    return res;
  }
}
