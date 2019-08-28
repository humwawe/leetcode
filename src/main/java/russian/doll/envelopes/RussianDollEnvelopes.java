package russian.doll.envelopes;

import java.util.Arrays;

/**
 * @author hum
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            int tmp = o1[0] - o2[0];
            if (tmp == 0) {
                return o1[1] - o2[1];
            } else {
                return tmp;
            }
        });

        int result = 1;
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
