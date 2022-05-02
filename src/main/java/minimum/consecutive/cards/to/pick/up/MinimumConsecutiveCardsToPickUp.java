package minimum.consecutive.cards.to.pick.up;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MinimumConsecutiveCardsToPickUp {
  public int minimumCardPickup(int[] cards) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = (int) 1e8;
    for (int i = 0; i < cards.length; i++) {
      Integer integer = map.get(cards[i]);
      if (integer != null) {
        res = Math.min(res, i - integer + 1);
      }
      map.put(cards[i], i);
    }
    if (res == (int) 1e8) {
      return -1;
    }
    return res;
  }
}
