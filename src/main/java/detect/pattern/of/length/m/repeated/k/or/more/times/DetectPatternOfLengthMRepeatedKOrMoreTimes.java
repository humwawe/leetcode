package detect.pattern.of.length.m.repeated.k.or.more.times;

/**
 * @author hum
 */
public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    public boolean containsPattern(int[] arr, int m, int k) {
        int len = arr.length;
        flag:
        for (int i = 0; i + m * k <= len; i++) {
            for (int j = i + m; j < i + m * k; ++j) {
                if (arr[j] != arr[j - m]) {
                    continue flag;
                }
            }
            return true;
        }
        return false;
    }
}
