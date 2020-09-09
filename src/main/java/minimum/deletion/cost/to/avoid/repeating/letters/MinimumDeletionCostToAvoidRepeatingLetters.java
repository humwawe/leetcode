package minimum.deletion.cost.to.avoid.repeating.letters;

/**
 * @author hum
 */
public class MinimumDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int len = s.length();
        int res = 0;
        int pos = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(pos)) {
                if (cost[i] < cost[pos]) {
                    res += cost[i];
                } else {
                    res += cost[pos];
                    pos = i;
                }
            } else {
                pos = i;
            }
        }
        return res;
    }
}
