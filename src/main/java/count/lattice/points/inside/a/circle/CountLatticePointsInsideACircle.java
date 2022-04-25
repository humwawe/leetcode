package count.lattice.points.inside.a.circle;

/**
 * @author hum
 */
public class CountLatticePointsInsideACircle {
  public int countLatticePoints(int[][] circles) {
    int res = 0;
    for (int i = 0; i < 205; i++) {
      for (int j = 0; j < 205; j++) {
        for (int[] circle : circles) {
          if ((i - circle[0]) * (i - circle[0]) + (j - circle[1]) * (j - circle[1]) <= circle[2] * circle[2]) {
            res++;
            break;
          }
        }
      }
    }
    return res;
  }
}
