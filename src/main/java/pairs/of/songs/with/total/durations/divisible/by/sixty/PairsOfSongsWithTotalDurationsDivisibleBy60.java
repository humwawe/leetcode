package pairs.of.songs.with.total.durations.divisible.by.sixty;

/**
 * @author hum
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        int[] h = new int[60];
        for (int i : time) {
            if (i % 60 == 0) {
                result += h[0];
            } else if (h[60 - i % 60] > 0) {
                result += h[60 - i % 60];
            }
            h[i % 60]++;
        }
        return result;
    }
}
