package candy;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author hum
 */
public class candy {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1] >= 2 ? 1 : 0;
                if (dp[i] == 0) {
                    dp[i] = 1;
                    int j = i - 1;
                    while (j >= 0 && ratings[j] > ratings[j + 1]) {
                        if (dp[j] == dp[j + 1]) {
                            dp[j] += 1;
                        }
                        j--;
                    }
                }
            }
        }
        int result = 0;
        for (int aDp : dp) {
            System.out.println(aDp);
            result += aDp;
        }
        return result;
    }
}
