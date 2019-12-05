package can.place.flowers;

/**
 * @author hum
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        int count = 1;
        for (int i : flowerbed) {
            if (i == 0) {
                count++;
            } else {
                res += (count - 1) / 2;
                if (res >= n) {
                    return true;
                }
                count = 0;
            }
        }
        res += count / 2;
        return res >= n;
    }
}
