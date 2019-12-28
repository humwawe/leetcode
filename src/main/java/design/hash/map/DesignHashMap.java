package design.hash.map;

import java.util.Arrays;

/**
 * @author hum
 */
public class DesignHashMap {
    int[] map = new int[1000000];

    public DesignHashMap() {
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }


    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
