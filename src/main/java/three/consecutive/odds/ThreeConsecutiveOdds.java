package three.consecutive.odds;

/**
 * @author hum
 */
public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int i : arr) {
            if (i % 2 == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }
}
