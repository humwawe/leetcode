package the.latest.time.to.get.on.a.bus;

import java.util.Arrays;

/**
 * @author hum
 */
public class TheLatestTimeToGetOnABus {
  public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
    Arrays.sort(buses);
    Arrays.sort(passengers);
    int j = 0, c = 0;
    for (int t : buses) {
      for (c = capacity; c > 0 && j < passengers.length && passengers[j] <= t; ++j) {
        --c;
      }
    }
    --j;

    int res = c > 0 ? buses[buses.length - 1] : passengers[j];
    while (j >= 0 && passengers[j--] == res) {
      --res;
    }
    return res;
  }

}
