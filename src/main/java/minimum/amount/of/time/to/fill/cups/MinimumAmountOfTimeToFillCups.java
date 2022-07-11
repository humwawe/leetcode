package minimum.amount.of.time.to.fill.cups;

import java.util.Arrays;

/**
 * @author hum
 */
public class MinimumAmountOfTimeToFillCups {
  public int fillCups(int[] amount) {
    Arrays.sort(amount);
    if (amount[2] >= amount[0] + amount[1]) {
      return amount[2];
    }
    return (amount[0] + amount[1] + amount[2] + 1) / 2;
  }
}
