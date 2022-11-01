package number.of.valid.clock.times;

/**
 * @author hum
 */
public class NumberOfValidClockTimes {
  public int countTime(String time) {
    int res = 0;
    f:
    for (int i = 0; i < 1440; i++) {
      String x = String.format("%02d:%02d", i / 60, i % 60);
      for (int j = 0; j < 5; j++) {
        if (time.charAt(j) != '?' && time.charAt(j) != x.charAt(j)) {
          continue f;
        }
      }
      res++;
    }
    return res;
  }
}
