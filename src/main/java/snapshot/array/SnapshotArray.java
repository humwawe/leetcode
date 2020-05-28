package snapshot.array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author hum
 */
public class SnapshotArray {
    List<TreeMap<Integer, Integer>> arr = new ArrayList<>();
    int snap = 0;

    public SnapshotArray(int length) {
        for (int i = 0; i < length; i++) {
            arr.add(new TreeMap<>());
        }
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        tm.put(snap, val);
    }

    public int snap() {
        return snap++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> tm = arr.get(index);
        Integer key = tm.floorKey(snapId);
        return key == null ? 0 : tm.get(key);
    }

}
