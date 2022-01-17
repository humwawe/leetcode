package solving.questions.with.brainpower;

/**
 * @author hum
 */
public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] dp = new long[len + 1];
        for (int i = len - 1; i >= 0; i--) {
            if (i + questions[i][1] + 1 < len) {
                dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[i + questions[i][1] + 1]);
            } else {
                dp[i] = Math.max(dp[i + 1], questions[i][0]);
            }
        }
        return dp[0];
    }
}
