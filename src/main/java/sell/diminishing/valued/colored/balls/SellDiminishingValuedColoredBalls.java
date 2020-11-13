package sell.diminishing.valued.colored.balls;

import java.util.TreeMap;

/**
 * @author hum
 */
public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((x, y) -> y - x);
        for (int value : inventory) {
            treeMap.put(value, treeMap.getOrDefault(value, 0) + 1);
        }
        long res = 0;
        int mod = (int) (1e9 + 7);
        while (orders > 0) {
            int fir = treeMap.firstKey();
            int cnt = treeMap.get(fir);
            treeMap.remove(fir);
            int sec = 0;
            if (treeMap.size() > 0) {
                sec = treeMap.firstKey();
            }
            long diff = fir - sec;
            if (diff * cnt < orders) {
                res += helper(fir, cnt, sec);
                res %= mod;
                orders -= diff * cnt;
                treeMap.put(sec, treeMap.get(sec) + cnt);
            } else {
                long t = orders / cnt;
                long tt = orders % cnt;
                res += helper(fir, cnt, fir - t);
                res %= mod;
                res += tt * (fir - t);
                res %= mod;
                orders = 0;
            }
        }
        return (int) (res % mod);

    }

    private long helper(long fir, long cnt, long sec) {
        if ((fir + sec + 1) % 2 == 0) {
            return (fir + sec + 1) / 2 * (fir - sec) * cnt;
        }
        return (fir + sec + 1) * ((fir - sec) / 2) * cnt;
    }
}
