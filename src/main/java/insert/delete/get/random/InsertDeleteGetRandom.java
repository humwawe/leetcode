package insert.delete.get.random;

import java.util.*;

/**
 * @author hum
 */
public class InsertDeleteGetRandom {
    private Map<Integer, Integer> map;
    private List<Integer> list;

    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int size = list.size();
        map.put(val, size);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int size = list.size();
        int last = list.get(size - 1);
        list.set(index, last);
        list.remove(size - 1);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int size = list.size();
        return list.get(new Random().nextInt(size));
    }
}
