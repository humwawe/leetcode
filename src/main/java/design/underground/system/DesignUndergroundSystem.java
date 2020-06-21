package design.underground.system;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class DesignUndergroundSystem {
    Map<Integer, Object[]> map;
    Map<String, Integer> map2;
    Map<String, Integer> map3;

    public DesignUndergroundSystem() {
        map = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        map.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] objects = map.get(id);
        String k = objects[0] + "#" + stationName;
        map2.put(k, map2.getOrDefault(k, 0) + t - (int) objects[1]);
        map3.put(k, map3.getOrDefault(k, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String k = startStation + "#" + endStation;
        return (double) map2.get(k) / map3.get(k);
    }
}
