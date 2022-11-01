package most.popular.video.creator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class MostPopularVideoCreator {
  public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
    Map<String, Long> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();
    long res = 0;
    int n = creators.length;
    for (int i = 0; i < n; i++) {
      if (!map2.containsKey(creators[i])) {
        map2.put(creators[i], i);
      } else {
        int temp = map2.get(creators[i]);
        if (views[i] > views[temp] || (views[i] == views[temp]) && ids[i].compareTo(ids[temp]) < 0) {
          map2.put(creators[i], i);
        }
      }
      map1.put(creators[i], map1.getOrDefault(creators[i], 0L) + views[i]);
      res = Math.max(map1.get(creators[i]), res);
    }
    List<List<String>> ans = new ArrayList<>();
    for (Map.Entry<String, Long> entry : map1.entrySet()) {
      if (entry.getValue() == res) {
        List<String> arr = new ArrayList<>();
        arr.add(entry.getKey());
        arr.add(ids[map2.get(entry.getKey())]);
        ans.add(new ArrayList<>(arr));
      }
    }
    return ans;
  }
}
