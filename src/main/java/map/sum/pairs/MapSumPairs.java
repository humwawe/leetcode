package map.sum.pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MapSumPairs {
    public Map<Character, Node> map;

    public MapSumPairs() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {

    }

    public int sum(String prefix) {

    }

    class Node {
        Map<Character, Node> map;
        int val;

        public Node(Map<Character, Node> map, int val) {
            this.map = map;
            this.val = val;
        }
    }
}
