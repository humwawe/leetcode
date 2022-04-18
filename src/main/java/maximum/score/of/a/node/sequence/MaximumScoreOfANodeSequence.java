package maximum.score.of.a.node.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MaximumScoreOfANodeSequence {
  public int maximumScore(int[] scores, int[][] edges) {
    List<int[]>[] pathScore = new List[scores.length];
    for (int i = 0; i < scores.length; i++) {
      pathScore[i] = new ArrayList<>();
    }
    for (int[] edge : edges) {
      int score = scores[edge[0]] + scores[edge[1]];
      pathScore[edge[0]].add(new int[]{edge[1], score});
      pathScore[edge[1]].add(new int[]{edge[0], score});
    }
    for (int i = 0; i < scores.length; i++) {
      pathScore[i].sort((a, b) -> b[1] - a[1]);
    }
    int ans = -1;
    for (int[] edge : edges) {
      for (int j = 0; j < 3 && j < pathScore[edge[0]].size(); j++) {
        int[] a = pathScore[edge[0]].get(j);
        for (int k = 0; k < 3 && k < pathScore[edge[1]].size(); k++) {
          int[] b = pathScore[edge[1]].get(k);
          if (a[0] != edge[1] && a[0] != b[0] && b[0] != edge[0]) {
            ans = Math.max(ans, a[1] + b[1]);
          }
        }
      }
    }
    return ans;
  }
}
