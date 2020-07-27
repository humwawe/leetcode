package count.odd.numbers.in.an.interval.range;

/**
 * @author hum
 */
public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        int a = (high + 1) / 2;
        int b = low / 2;
        return a - b;
    }
}
