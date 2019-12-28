package random.pick.with.blacklist;

import java.util.*;

/**
 * @author hum
 */
public class RandomPickWithBlacklist {
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    int size;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        int len = blacklist.length;
        size = n - len;
        Set<Integer> set = new HashSet<>();
        for (int i = size; i < n; i++) {
            set.add(i);
        }
        for (int i : blacklist) {
            set.remove(i);
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i : blacklist) {
            if (i < size) {
                map.put(i, iterator.next());
            }
        }
    }

    public int pick() {
        int i = random.nextInt(size);
        return map.getOrDefault(i, i);
    }
}
