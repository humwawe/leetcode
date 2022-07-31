package best.poker.hand;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class BestPokerHand {
  public String bestHand(int[] ranks, char[] suits) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int rank : ranks) {
      map.put(rank, map.getOrDefault(rank, 0) + 1);
    }

    boolean flag = true;
    for (int i = 1; i < 5; i++) {
      if (suits[i] != suits[i - 1]) {
        flag = false;
        break;
      }
    }

    if (flag) {
      return "Flush";
    }

    boolean three = false, two = false;
    for (Integer value : map.values()) {
      if (value >= 3) {
        three = true;
      }
      if (value >= 2) {
        two = true;
      }
    }

    if (three) {
      return "Three of a Kind";
    }
    if (two) {
      return "Pair";
    }

    return "High Card";
  }
}
