package number.of.ways.to.divide.a.lon.corridor;

/**
 * @author hum
 */
public class NumberOfWaysToDivideALonCorridor {
    public int numberOfWays(String corridor) {
        int len = corridor.length();
        int chairNum = 0;
        int plantsNum = 0;
        long result = 1;
        for (int i = 0; i < len; i++) {
            if (corridor.charAt(i) == 'S') {
                chairNum++;
                if (chairNum % 2 == 1 && chairNum != 1) {
                    result *= (plantsNum + 1);
                    result %= 1000000007;
                }
                plantsNum = 0;
            } else {
                plantsNum++;
            }
        }
        if (chairNum % 2 != 0 || chairNum == 0) {
            return 0;
        }
        return (int) result;
    }
}
