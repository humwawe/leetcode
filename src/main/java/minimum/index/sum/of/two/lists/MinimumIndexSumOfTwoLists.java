package minimum.index.sum.of.two.lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int result = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tmp = i + map.get(list2[i]);
                if (result > tmp) {
                    list.clear();
                    list.add(list2[i]);
                    result = tmp;
                } else if (result == tmp) {
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
