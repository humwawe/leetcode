package time.based.key.value.store;

import java.util.*;

/**
 * @author hum
 */
public class TimeBasedKeyValueStore {
    Map<String, List<String>> map;
    Map<String, List<Integer>> map2;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            List<String> list = new ArrayList<>();
            list.add(value);
            List<Integer> list2 = new ArrayList<>();
            list2.add(timestamp);
            map.put(key, list);
            map2.put(key, list2);
        } else {
            map.get(key).add(value);
            map2.get(key).add(timestamp);
        }
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Integer> list = map2.get(key);
        if (list.get(0) > timestamp) {
            return "";
        }
        int i = Collections.binarySearch(list, timestamp);
        System.out.println(i);
        if (i >= 0) {
            return map.get(key).get(i);
        }
        return map.get(key).get(-i - 1);
    }
}
