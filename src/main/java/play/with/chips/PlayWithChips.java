package play.with.chips;

/**
 * @author hum
 */
public class PlayWithChips {
    public int minCostToMoveChips(int[] chips) {
        int len = chips.length;
        int count = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) {
                count++;
            }
        }
        return Math.min(len - count, count);
    }
}
