package count.artifacts.that.can.be.extracted;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class CountArtifactsThatCanBeExtracted {
  public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
    Set<Integer> set = new HashSet<>();
    for (int[] ints : dig) {
      set.add(ints[0] * 1005 + ints[1]);
    }
    int res = 0;
    f:
    for (int[] artifact : artifacts) {
      for (int i = artifact[0]; i <= artifact[2]; i++) {
        for (int j = artifact[1]; j <= artifact[3]; j++) {
          if (!set.contains(i * 1005 + j)) {
            continue f;
          }
        }
      }
      res++;
    }
    return res;
  }
}
