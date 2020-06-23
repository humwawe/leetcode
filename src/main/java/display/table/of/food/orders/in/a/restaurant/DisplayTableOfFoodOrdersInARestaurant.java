package display.table.of.food.orders.in.a.restaurant;

import java.util.*;

/**
 * @author hum
 */
public class DisplayTableOfFoodOrdersInARestaurant {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> result = new ArrayList<>();
        TreeMap<String, Map<String, Integer>> map = new TreeMap<>(Comparator.comparingInt(Integer::valueOf));
        Set<String> set = new HashSet<>();
        for (List<String> order : orders) {
            String t = order.get(1);
            String f = order.get(2);
            set.add(f);
            if (!map.containsKey(t)) {
                map.put(t, new HashMap<>());
            }
            Map<String, Integer> map1 = map.get(t);
            map1.put(f, map1.getOrDefault(f, 0) + 1);
            map.put(t, map1);
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        list.add(0, "Table");
        result.add(list);

        for (String s : map.keySet()) {
            List<String> tmp = new ArrayList<>();
            tmp.add(s);
            Map<String, Integer> map1 = map.get(s);
            for (int i = 1; i < list.size(); i++) {
                tmp.add(String.valueOf(map1.getOrDefault(list.get(i), 0)));
            }
            result.add(tmp);
        }
        return result;
    }
}
