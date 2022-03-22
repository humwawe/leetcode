package count.collisions.on.a.road;

/**
 * @author hum
 */
public class CountCollisionsOnARoad {
  public int countCollisions(String directions) {
    int l = 0, r = directions.length() - 1;
    int res = 0;
    while (l <= r && directions.charAt(l) == 'L') {
      l++;
    }
    while (l <= r && directions.charAt(r) == 'R') {
      r--;
    }
    for (int i = l; i <= r; i++) {
      if (directions.charAt(i) == 'L' || directions.charAt(i) == 'R') {
        res++;
      }
    }
    return res;
  }
}
