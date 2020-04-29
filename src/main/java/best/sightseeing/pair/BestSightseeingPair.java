package best.sightseeing.pair;

/**
 * @author hum
 */
public class BestSightseeingPair {
    public int maxScoreSightseeingPair(int[] a) {
        int max = a[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
            result = Math.max(result, a[i] - i + max);
            max = Math.max(max, a[i] + i);
        }
        return result;
    }
}
