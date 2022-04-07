package find.players.with.zero.or.one.losses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindPlayersWithZeroOrOneLosses {
  public List<List<Integer>> findWinners(int[][] matches) {
    int max = 0;
    for (int[] match : matches) {
      for (int i : match) {
        max = Math.max(max, i);
      }
    }
    int[] indegree = new int[max + 1];
    int[] outdegree = new int[max + 1];
    for (int[] match : matches) {
      ++outdegree[match[0]];
      ++indegree[match[1]];
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> allWins = new ArrayList<>();
    List<Integer> oneLoses = new ArrayList<>();
    for (int i = 0; i < max + 1; i++) {
      if (indegree[i] == 0 && outdegree[i] > 0) {
        allWins.add(i);
      } else if (indegree[i] == 1) {
        oneLoses.add(i);
      }
    }
    ans.add(allWins);
    ans.add(oneLoses);
    return ans;
  }

}
