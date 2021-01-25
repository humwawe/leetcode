package find.the.highest.altitude;

/**
 * @author hum
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int tmp = 0;
        int res = 0;
        for (int i : gain) {
            tmp += i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
