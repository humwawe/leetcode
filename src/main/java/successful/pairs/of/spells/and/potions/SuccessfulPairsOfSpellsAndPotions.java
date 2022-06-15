package successful.pairs.of.spells.and.potions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class SuccessfulPairsOfSpellsAndPotions {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int n = spells.length;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> spells[x]));
    int m = potions.length;
    int[] res = new int[n];
    int j = m;
    for (int i = 0; i < n; i++) {
      while (j - 1 >= 0 && (long) spells[idx[i]] * potions[j - 1] >= success) {
        j--;
      }
      res[idx[i]] = m - j;
    }
    return res;
  }
}
