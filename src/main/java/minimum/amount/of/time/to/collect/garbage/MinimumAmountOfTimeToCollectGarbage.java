package minimum.amount.of.time.to.collect.garbage;

/**
 * @author hum
 */
public class MinimumAmountOfTimeToCollectGarbage {
  public int garbageCollection(String[] garbage, int[] travel) {
    int cm = 0, cp = 0, cg = 0;
    int lastm = 0, lastp = 0, lastg = 0;
    for (int i = 0; i < garbage.length; i++) {
      String garbageStr = garbage[i];
      for (Character c : garbageStr.toCharArray()) {
        if (c == 'M') {
          cm++;
          lastm = i;
        }
        if (c == 'P') {
          cp++;
          lastp = i;
        }
        if (c == 'G') {
          cg++;
          lastg = i;
        }
      }
    }
    int res = cg + cm + cp;
    for (int i = 0; i < travel.length; i++) {
      if (lastg > i) {
        res += travel[i];
      }
      if (lastm > i) {
        res += travel[i];
      }
      if (lastp > i) {
        res += travel[i];
      }
    }
    return res;
  }

}
