package insert.delete.get.random.duplicates.allowed;

import java.util.*;

/**
 * @author hum
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    private Map<Integer, List<Integer>> map;
    private List<Integer> list;

    public InsertDeleteGetRandomDuplicatesAllowed() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        int size = list.size();
        if (map.containsKey(val)) {
            map.get(val).add(size);
            list.add(val);
            return false;
        }
        List<Integer> tmp = new ArrayList<>();
        tmp.add(size);
        map.put(val, tmp);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        List<Integer> tmp = map.get(val);
        int size = list.size() - 1;
        int delIndex = tmp.get(tmp.size() - 1);
        int last = list.get(size);
        list.set(delIndex, last);
        map.get(last).set(map.get(last).indexOf(size), delIndex);
        list.remove(size);
        tmp.remove(tmp.indexOf(delIndex));
        return true;

    }

    public int getRandom() {
        int size = list.size();
        return list.get(new Random().nextInt(size));
    }
}
