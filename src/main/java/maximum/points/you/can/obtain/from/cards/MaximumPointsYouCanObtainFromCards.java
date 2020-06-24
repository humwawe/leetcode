package maximum.points.you.can.obtain.from.cards;

/**
 * @author hum
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + cardPoints[i];
        }
        int result = 0;
        for (int i = 0; i <= k; i++) {
            int l = sum[i];
            int r = sum[len] - sum[len - (k - i)];
            result = Math.max(result, l + r);
        }
        return result;
    }
}
