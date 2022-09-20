package maximum.matching.of.players.with.trainers;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumMatchingOfPlayersWithTrainers {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    Arrays.sort(players);
    Arrays.sort(trainers);
    int j = 0;
    int res = 0;
    for (int player : players) {
      while (j < trainers.length && trainers[j] < player) {
        j++;
      }
      if (j >= trainers.length) {
        continue;
      }
      j++;
      res++;
    }
    return res;
  }
}
