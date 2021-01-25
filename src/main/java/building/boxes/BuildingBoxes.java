package building.boxes;

/**
 * @author hum
 */
public class BuildingBoxes {
    public int minimumBoxes(int n) {
        int tmp = 0;
        int res = 0;
        int cnt = 1;

        while (tmp <= n) {
            for (int j = 1; j <= cnt; j++) {
                tmp += j;
                res++;
                if (tmp >= n) {
                    return res;
                }
            }
            cnt++;
        }
        return res;
    }
}
