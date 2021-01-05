package maximum.units.on.a.truck;

import java.util.Arrays;

/**
 * @author hum
 */
public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] <= truckSize) {
                res += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                res += truckSize * boxType[1];
                break;
            }
        }
        return res;
    }
}
