package number.of.ways.to.form.a.target.string.given.a.dictionary;

/**
 * @author hum
 */
public class NumberOfWaysToFormATargetStringGivenADictionary {
    int len1;
    int len2;
    int mod = (int) (1e9 + 7);
    int[][] cnt = new int[1000][26];
    String t;
    Long[][] memo = new Long[1005][1005];

    public int numWays(String[] words, String target) {
        len1 = words[0].length();
        len2 = target.length();
        t = target;
        for (int i = 0; i < len1; i++) {
            for (String word : words) {
                cnt[i][word.charAt(i) - 'a']++;
            }
        }
        return (int) (helper(0, 0) % mod);
    }

    private long helper(int i, int j) {
        if (i == len1) {
            if (j == len2) {
                return 1;
            }
            return 0;
        }
        if (j == len2) {
            return 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = (helper(i + 1, j) + helper(i + 1, j + 1) * cnt[i][t.charAt(j) - 'a']) % mod;
    }
}
