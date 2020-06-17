package filter.restaurants.by.vegan.friendly.price.and.distance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class FilterRestaurantsByVeganFriendlyPriceAndDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[4] > maxDistance || restaurant[3] > maxPrice) {
                continue;
            }
            if (veganFriendly == 1 && restaurant[2] == 0) {
                continue;
            }
            map.put(restaurant[0], restaurant[1]);
            result.add(restaurant[0]);
        }
        result.sort((a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(b) - map.get(a));
        return result;
    }
}
