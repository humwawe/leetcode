package count.ways.to.build.rooms.in.an.ant.colony;

import java.util.Arrays;

/**
 * @author hum
 */
public class CountWaysToBuildRoomsInAnAntColony {
    int[] h;
    int[] e;
    int[] ne;
    int idx;
    int[] size;
    int mod = (int) (1e9 + 7);
    int len;

    public int waysToBuildRooms(int[] prevRoom) {
        len = prevRoom.length;
        h = new int[len];
        e = new int[len];
        ne = new int[len];
        size = new int[len];
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 1; i < len; i++) {
            add(prevRoom[i], i);
        }
        fact(len);
        return (int) (dfs(0) % mod);
    }

    private long dfs(int u) {
        long res = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            long tmp = dfs(j);
            size[u] += size[j];
            res = res * com(size[u], size[j]) % mod * tmp % mod;
        }
        size[u]++;
        return res;
    }

    long[] fact;
    long[] infact;

    void fact(int len) {
        fact = new long[len];
        infact = new long[len];
        fact[0] = infact[0] = 1;
        for (int i = 1; i < len; i++) {
            fact[i] = fact[i - 1] * i % mod;
            infact[i] = infact[i - 1] * qmi(i, mod - 2, mod) % mod;
        }
    }

    int qmi(int m, int k, int p) {
        long res = 1 % p, t = m;
        while (k > 0) {
            if ((k & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            k >>= 1;
        }
        return (int) res % p;
    }

    private long com(int a, int b) {
        return fact[a] * infact[b] % mod * infact[a - b] % mod;
    }


    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
