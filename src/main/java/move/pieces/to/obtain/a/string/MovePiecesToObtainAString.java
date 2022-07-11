package move.pieces.to.obtain.a.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class MovePiecesToObtainAString {
  public boolean canChange(String start, String target) {
    if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
      return false;
    }

    int len = start.length();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    List<Integer> list3 = new ArrayList<>();
    List<Integer> list4 = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      if (start.charAt(i) == 'L') {
        list1.add(i);
      } else if (start.charAt(i) == 'R') {
        list2.add(i);
      }
    }
    for (int i = 0; i < len; i++) {
      if (target.charAt(i) == 'L') {
        list3.add(i);
      } else if (target.charAt(i) == 'R') {
        list4.add(i);
      }
    }
    for (int i = 0; i < list1.size(); i++) {
      if (list1.get(i) < list3.get(i)) {
        return false;
      }
    }
    for (int i = 0; i < list2.size(); i++) {
      if (list2.get(i) > list4.get(i)) {
        return false;
      }
    }
    return true;
  }
}
