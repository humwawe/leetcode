package stock.price.fluctuation;

import java.util.TreeMap;

/**
 * @author hum
 */
public class StockPriceFluctuation {
    TreeMap<Integer, Integer> t1 = new TreeMap<>();
    TreeMap<Integer, Integer> t2 = new TreeMap<>();

    public StockPriceFluctuation() {

    }

    public void update(int timestamp, int price) {
        Integer oldP = t1.get(timestamp);
        if (oldP != null) {
            t2.put(oldP, t2.get(oldP) - 1);
            if (t2.get(oldP) == 0) {
                t2.remove(oldP);
            }
        }
        t1.put(timestamp, price);
        t2.put(price, t2.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return t1.lastEntry().getValue();
    }

    public int maximum() {
        return t2.lastKey();
    }

    public int minimum() {
        return t2.firstKey();
    }
}
