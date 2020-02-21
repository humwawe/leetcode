package n.twenty.one.game;


/**
 * @author hum
 */
public class New21Game {
    public double new21Game(int n, int k, int w) {
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i - 1 < k) {
                sum += dp[i - 1];
            }
            if (i - w - 1 >= 0) {
                sum -= dp[i - w - w];
            }
            dp[i] = sum / w;
        }
        double result = 0;
        for (int i = k; i <= n; i++) {
            result += dp[i];
        }
        return result;
    }
}
