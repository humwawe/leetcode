package find.right.interval;


import java.util.TreeMap;

/**
 * @author hum
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            map.put(interval[0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            Integer integer = map.ceilingKey(interval[1]);
            if (integer != null) {
                result[i] = map.get(integer);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 2);
        System.out.println(map.higherKey(0));
        System.out.println(map.ceilingKey(1));
    }
}
