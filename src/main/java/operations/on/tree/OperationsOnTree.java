package operations.on.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class OperationsOnTree {
    int[] p;
    int N = 2005;
    int M = N;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    Map<Integer, Integer> map = new HashMap<>();

    public OperationsOnTree(int[] parent) {
        p = parent;
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 1; i < parent.length; i++) {
            add(parent[i], i);
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean lock(int num, int user) {
        if (map.containsKey(num)) {
            return false;
        }
        map.put(num, user);
        return true;
    }

    public boolean unlock(int num, int user) {
        Integer o = map.getOrDefault(num, -1);
        if (o == user) {
            map.remove(num);
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (map.containsKey(num)) {
            return false;
        }
        int t = num;
        while (t != -1 && !map.containsKey(t)) {
            t = p[t];
        }
        if (t != -1) {
            return false;
        }
        boolean has = remove(num);
        if (has) {
            map.put(num, user);
            return true;
        }
        return false;
    }

    private boolean remove(int u) {
        boolean f = false;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (remove(j)) {
                f = true;
            }
        }
        if (map.containsKey(u)) {
            f = true;
            map.remove(u);
        }
        return f;
    }
}
