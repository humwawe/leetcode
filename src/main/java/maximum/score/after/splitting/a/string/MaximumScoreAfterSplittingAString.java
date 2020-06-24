package maximum.score.after.splitting.a.string;

/**
 * @author hum
 */
public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
            int l = cnt;
            int r = len - 1 - i - (count - cnt);
            result = Math.max(result, l + r);
        }
        return result;
    }
}
