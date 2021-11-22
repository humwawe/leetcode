package watering.plants;

/**
 * @author hum
 */
public class WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int len = plants.length;
        int res = 0;
        int tmp = capacity;
        for (int i = 0; i < len; i++) {
            if (tmp >= plants[i]) {
                tmp -= plants[i];
            } else {
                res += 2 * i;
                tmp = capacity - plants[i];
            }
            res++;
        }
        return res;
    }
}
