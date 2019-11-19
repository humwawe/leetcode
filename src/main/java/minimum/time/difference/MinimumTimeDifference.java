package minimum.time.difference;

import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int result = Integer.MAX_VALUE;
        int lastH = Integer.valueOf(timePoints.get(0).substring(0, 2).replaceAll("00", "0"));
        int lastM = Integer.valueOf(timePoints.get(0).substring(2).replaceAll("00", "0"));
        for (int i = 1; i < timePoints.size(); i++) {
            int h = Integer.valueOf(timePoints.get(i).substring(0, 2).replaceAll("00", "0"));
            int m = Integer.valueOf(timePoints.get(i).substring(2).replaceAll("00", "0"));
            result = Math.min(result, (h - lastH) * 60 + m - lastM);
            lastH = h;
            lastM = m;
        }
        int tmpH = Integer.valueOf(timePoints.get(0).substring(0, 2).replaceAll("00", "0"));
        int tmpM = Integer.valueOf(timePoints.get(0).substring(2).replaceAll("00", "0"));
        result = Math.min(result, (tmpH + 24 - lastH) * 60 + tmpM - lastM);
        return result;
    }
}
