package meeting.rooms.iii;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hum
 */
public class MeetingRoomsIii {
  public int mostBooked(int n, int[][] meetings) {

    Arrays.sort(meetings, Comparator.comparingInt(x -> x[0]));

    PriorityQueue<Integer> p1 = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      p1.add(i);
    }
    PriorityQueue<long[]> p2 = new PriorityQueue<>((x, y) -> {
      long d = x[0] - y[0];
      if (d == 0) {
        return Long.compare(x[1], y[1]);
      }
      return (int) d;
    });
    int len = meetings.length;
    int[] res = new int[n];
    for (int[] meeting : meetings) {
      long start = meeting[0];
      while (!p2.isEmpty() && p2.peek()[0] <= start) {
        p1.add((int) p2.poll()[1]);
      }
      if (p1.isEmpty()) {
        start = p2.peek()[0];
        p1.add((int) p2.poll()[1]);
      }
      Integer id = p1.poll();
      res[id]++;

      p2.add(new long[]{start + (meeting[1] - meeting[0]), id});
    }
    int maxId = 0;
    for (int i = 0; i < n; i++) {
      if (res[i] > res[maxId]) {
        maxId = i;
      }
    }
    return maxId;
  }
}
