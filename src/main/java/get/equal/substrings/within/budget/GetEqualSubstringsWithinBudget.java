package get.equal.substrings.within.budget;

/**
 * @author hum
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int result = 0;
        int len = s.length();
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int sum = 0;
        int l = 0;
        for (int i = 0; i < len; i++) {
            sum += tmp[i];
            while (sum > maxCost) {
                sum -= tmp[l];
                l++;
            }
            result = Math.max(result, i - l + 1);
        }
        return result;
    }
}
