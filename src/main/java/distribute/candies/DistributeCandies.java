package distribute.candies;


import java.util.HashSet;
import java.util.Set;

/**
 * @author hum
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }
}
