package probability.of.a.two.boxes.having.the.same.number.of.distinct.balls;

/**
 * @author hum
 */
public class ProbabilityOfATwoBoxesHavingTheSameNumberOfDistinctBalls {
    int all;
    double res = 0;
    long[] f = new long[7];

    public double getProbability(int[] balls) {
        for (int ball : balls) {
            all += ball;
        }
        f[0] = 1;
        for (int i = 1; i < 7; i++) {
            f[i] = f[i - 1] * i;
        }
        double tmp = helper2(balls);
        int[] count = new int[balls.length];
        helper(balls, 0, 0, 0, 0, count);
        return res / tmp;
    }

    private void helper(int[] balls, int i, int i1, int i2, int sum, int[] c) {
        if (i == balls.length) {
            if (i1 == i2 && sum == all / 2) {
                int[] c2 = new int[c.length];
                for (int j = 0; j < c.length; j++) {
                    c2[j] = balls[j] - c[j];
                }
                res = res + helper2(c) * (helper2(c2));
            }
            return;
        }
        if (sum > all / 2) {
            return;
        }
        for (int j = 0; j <= balls[i]; j++) {
            int t1 = j == 0 ? 0 : 1;
            int t2 = balls[i] - j == 0 ? 0 : 1;
            c[i] = j;
            helper(balls, i + 1, i1 + t1, i2 + t2, sum + j, c);
        }
    }

    double helper2(int[] c) {
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            sum += c[i];
        }
        double tmp = 1;
        for (int i = 1; i <= sum; i++) {
            tmp = tmp * i;
        }
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 1) {
                tmp = tmp / f[c[i]];
            }
        }
        return tmp;
    }

}
