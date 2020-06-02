package can.make.palindrome.from.substring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CanMakePalindromeFromSubstring {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int len = s.length();
        int[][] sum = new int[len + 1][26];
        for (int i = 1; i <= len; i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }
            sum[i][c - 'a']++;
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1] + 1;
            int k = query[2];
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if ((sum[r][i] - sum[l][i]) % 2 == 1) {
                    count++;
                }
            }
            result.add(count / 2 <= k);
        }
        return result;
    }
}
