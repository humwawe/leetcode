package minimum.time.to.complete.trips;

/**
 * @author hum
 */
public class MinimumTimeToCompleteTrips {
  int[] time;
  int total;

  public long minimumTime(int[] time, int totalTrips) {
    this.time = time;
    total = totalTrips;
    long l = 1;
    long r = (long) 1e14;
    while (l < r) {
      long mid = l + r >> 1;
      if (check(mid)) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private boolean check(long mid) {
    long res = 0;
    for (int i : time) {
      res += mid / i;

    }
    System.out.println(res);
    return res >= total;
  }
}
