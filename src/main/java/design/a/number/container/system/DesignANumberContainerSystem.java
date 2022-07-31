package design.a.number.container.system;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author hum
 */
public class DesignANumberContainerSystem {
  Map<Integer, Integer> map = new HashMap<>();
  Map<Integer, TreeSet<Integer>> map2 = new HashMap<>();

  public DesignANumberContainerSystem() {

  }

  public void change(int index, int number) {
    if (map.containsKey(index)) {
      Integer old = map.get(index);
      map2.get(old).remove(index);
    }
    map.put(index, number);
    map2.computeIfAbsent(number, e -> new TreeSet<>()).add(index);
  }

  public int find(int number) {
    if (!map2.containsKey(number) || map2.get(number).size() == 0) {
      return -1;
    }
    return map2.get(number).first();
  }
}
