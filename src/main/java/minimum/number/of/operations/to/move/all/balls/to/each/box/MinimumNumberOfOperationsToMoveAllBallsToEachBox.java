package minimum.number.of.operations.to.move.all.balls.to.each.box;

/**
 * @author hum
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        char[] chars = boxes.toCharArray();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && chars[j] == '1') {
                    res[i] += Math.abs(i - j);
                }
            }
        }
        return res;
    }
}
