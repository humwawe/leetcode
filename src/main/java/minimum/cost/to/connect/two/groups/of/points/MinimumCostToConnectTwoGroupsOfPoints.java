package minimum.cost.to.connect.two.groups.of.points;

import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class MinimumCostToConnectTwoGroupsOfPoints {
    int size1;
    int size2;
    int inf = (int) 1e8;

    public int connectTwoGroups(List<List<Integer>> cost) {
        size1 = cost.size();
        size2 = cost.get(0).size();
        int lim = (1 << size2);
        int[][] dp = new int[size1 + 1][lim];
        for (int i = 2; i <= size1; i++) {
            Arrays.fill(dp[i], inf);
        }
        int[][] costMatrix = new int[size1][lim];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < lim; j++) {
                int sum = 0;
                for (int k = 0; k < size2; k++) {
                    if ((j & (1 << k)) > 0) {
                        sum += cost.get(i).get(k);
                    }
                }
                costMatrix[i][j] = sum;
            }
        }

        for (int j = 1; j < lim; j++) {
            dp[1][j] = costMatrix[0][j];
        }
        for (int i = 2; i <= size1; i++) {
            for (int j = 1; j < lim; j++) {
                int st = (lim - 1) ^ j;
                for (int k = st; k > 0; k = (k - 1) & st) {
                    dp[i][j | k] = Math.min(dp[i][j | k], dp[i - 1][j] + costMatrix[i - 1][k]);
                }
                for (int k = 0; k < size2; k++) {
                    dp[i][j | (1 << k)] = Math.min(dp[i][j | (1 << k)], dp[i - 1][j] + costMatrix[i - 1][1 << k]);
                }

            }
        }
        return dp[size1][lim - 1];
    }

}
