package online.election;

import java.util.TreeMap;

/**
 * @author hum
 */
public class OnlineElection {
    int maxP = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public OnlineElection(int[] persons, int[] times) {
        int[] p = new int[5005];
        int len = persons.length;
        for (int i = 0; i < len; i++) {
            if (++p[persons[i]] >= p[maxP]) {
                maxP = persons[i];
            }
            map.put(times[i], maxP);
        }
    }

    public int q(int t) {
        Integer integer = map.floorKey(t);
        if (integer == null) {
            return map.lastEntry().getValue();
        }
        return map.get(integer);
    }
}
