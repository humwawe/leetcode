package array.of.doubled.pairs;

import java.util.TreeMap;

/**
 * @author hum
 */
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] a) {
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        int count = 0;
        for (int i : a) {
            if (i == 0) {
                count++;
            } else if (i > 0) {
                map1.put(i, map1.getOrDefault(i, 0) + 1);
            } else {
                map2.put(i, map2.getOrDefault(i, 0) + 1);
            }
        }
        if (count % 2 != 0) {
            return false;
        }
        System.out.println(map1);
        System.out.println(map2);
        while (!map1.isEmpty()) {
            Integer integer = map1.firstKey();
            if (map1.containsKey(integer * 2)) {
                map1.put(integer, map1.get(integer) - 1);
                if (map1.get(integer) == 0) {
                    map1.remove(integer);
                }
                map1.put(integer * 2, map1.get(integer * 2) - 1);
                if (map1.get(integer * 2) == 0) {
                    map1.remove(integer * 2);
                }
            } else {
                return false;
            }
        }
        while (!map2.isEmpty()) {
            Integer integer = map2.lastKey();
            if (map2.containsKey(integer * 2)) {
                map2.put(integer, map2.get(integer) - 1);
                if (map2.get(integer) == 0) {
                    map2.remove(integer);
                }
                map2.put(integer * 2, map2.get(integer * 2) - 1);
                if (map2.get(integer * 2) == 0) {
                    map2.remove(integer * 2);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
