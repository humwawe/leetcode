package lru.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hum
 */
public class LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;
    private int capacity;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap<>(capacity + 1);
        this.capacity = capacity;
    }

    public int get(int key) {
        int value = linkedHashMap.getOrDefault(key, -1);
        if (value != -1) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        linkedHashMap.remove(key);
        linkedHashMap.put(key, value);
        if (linkedHashMap.size() == capacity + 1) {
            Map.Entry<Integer, Integer> next = linkedHashMap.entrySet().iterator().next();
            linkedHashMap.remove(next.getKey());
        }
    }
}
