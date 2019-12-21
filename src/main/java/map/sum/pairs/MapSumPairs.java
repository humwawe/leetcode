package map.sum.pairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MapSumPairs {
    private Node root;

    public MapSumPairs() {
        root = new Node(-1);
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new Node(0));
            }
            cur = cur.map.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.map.containsKey(c)) {
                return 0;
            }
            cur = cur.map.get(c);
        }
        return helper(cur);
    }

    private int helper(Node cur) {
        int res = cur.val;
        for (Character c : cur.map.keySet()) {
            res += helper(cur.map.get(c));
        }
        return res;
    }

    class Node {
        Map<Character, Node> map;
        int val;

        public Node(int val) {
            this.map = new HashMap<>();
            this.val = val;
        }
    }
}
