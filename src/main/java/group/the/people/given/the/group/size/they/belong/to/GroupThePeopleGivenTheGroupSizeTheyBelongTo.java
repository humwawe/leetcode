package group.the.people.given.the.group.size.they.belong.to;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            List<Integer> list = map.get(integer);
            int count = list.size() / integer;
            for (int i = 0; i < count; i++) {
                List<Integer> res = new ArrayList<>(list.subList(integer * i, integer + integer * i));
                result.add(res);
            }
        }
        return result;
    }
}
