package couples.holding.hands;

/**
 * @author hum
 */
public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int[] index = new int[len];
        for (int i = 0; i < len; i++) {
            index[row[i]] = i;
        }
        int result = 0;
        for (int i = 0; i < len; i += 2) {
            if ((row[i] % 2 == 0 && row[i + 1] == row[i] + 1) || (row[i] % 2 == 1 && row[i + 1] == row[i] - 1)) {
                continue;
            }
            int pair = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            index[row[i + 1]] = index[pair];
            row[index[pair]] = row[i + 1];
            result++;
        }
        return result;
    }
}
