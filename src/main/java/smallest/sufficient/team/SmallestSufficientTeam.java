package smallest.sufficient.team;

import java.util.*;

/**
 * @author hum
 */
public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < reqSkills.length; i++) {
            map.put(reqSkills[i], i);
        }
        int len = people.size();
        int[][] dp = new int[len + 1][1 << reqSkills.length];
        int[][] pre = new int[len + 1][1 << reqSkills.length];
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        for (int i = 0; i <= len; i++) {
            Arrays.fill(pre[i], 0x3f3f3f3f);
        }
        for (int i = 0; i <= len; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= len; i++) {
            List<String> list = people.get(i - 1);
            int t = 0;
            for (String s : list) {
                int u = map.get(s);
                t |= 1 << u;
            }
            for (int j = (1 << reqSkills.length) - 1; j >= 0; j--) {
                if (dp[i - 1][j] == 0x3f3f3f3f) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                int k = j | t;
                if (dp[i][k] > dp[i - 1][j] + 1) {
                    dp[i][k] = dp[i - 1][j] + 1;
                    pre[i][k] = j;
                }

            }
        }
        List<Integer> list = new ArrayList<>();
        int j = (1 << reqSkills.length) - 1;
        for (int i = len; i >= 1; i--) {
            if (dp[i][j] != dp[i - 1][j]) {
                list.add(0, i - 1);
                j = pre[i][j];
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
