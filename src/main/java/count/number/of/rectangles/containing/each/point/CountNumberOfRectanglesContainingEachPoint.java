package count.number.of.rectangles.containing.each.point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class CountNumberOfRectanglesContainingEachPoint {
  public int[] countRectangles(int[][] rectangles, int[][] points) {
    List<Integer>[] lists = new List[101];
    for (int i = 0; i < 101; i++) {
      lists[i] = new ArrayList<>();
    }
    for (int[] rectangle : rectangles) {
      lists[rectangle[1]].add(rectangle[0]);
    }
    for (List<Integer> list : lists) {
      Collections.sort(list);
    }
    int[] res = new int[points.length];
    for (int j = 0, pointsLength = points.length; j < pointsLength; j++) {
      int[] point = points[j];
      for (int i = point[1]; i < 101; i++) {
        int idx = Collections.binarySearch(lists[i], point[0]);
        res[j] += lists[i].size() - (idx < 0 ? ~idx : idx);
      }
    }
    return res;
  }
}
