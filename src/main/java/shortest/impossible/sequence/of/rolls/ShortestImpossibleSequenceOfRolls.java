package shortest.impossible.sequence.of.rolls;

/**
 * @author hum
 */
public class ShortestImpossibleSequenceOfRolls {
  public int shortestSequence(int[] rolls, int k) {
    int[] mark = new int[k + 1];
    int ans = 1, left = k;
    for (int v : rolls) {
      if (mark[v] < ans) {
        mark[v] = ans;
        if (--left == 0) {
          left = k;
          ++ans;
        }
      }
    }
    return ans;
  }

}
