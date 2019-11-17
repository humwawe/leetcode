package random.pick.with.weight;

import java.util.Random;
import java.util.TreeMap;

/**
 * @author hum
 */
public class RandomPickWithWeight {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    Random rand = new Random();
    int sum = 0;

    public RandomPickWithWeight(int[] w) {
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            treeMap.put(sum, i);
        }
    }

    public int pickIndex() {
        int i = rand.nextInt(sum) + 1;
        return treeMap.ceilingEntry(i).getValue();
    }
}
