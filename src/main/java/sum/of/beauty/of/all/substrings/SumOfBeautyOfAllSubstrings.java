package sum.of.beauty.of.all.substrings;

/**
 * @author hum
 */
public class SumOfBeautyOfAllSubstrings {
    public int beautySum(String s) {
        int len = s.length();
        int res = 0;
        char[] tmp = s.toCharArray();
        for (int i = 0; i < len - 2; i++) {
            int[] cnt = new int[26];
            cnt[tmp[i] - 'a']++;
            cnt[tmp[i + 1] - 'a']++;
            for (int j = i + 2; j < len; j++) {
                cnt[tmp[j] - 'a']++;
                int max = 0;
                int min = 1000;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] != 0) {
                        max = Math.max(cnt[k], max);
                        min = Math.min(cnt[k], min);
                    }
                }
                res += max - min;
            }
        }
        return res;
    }
}
