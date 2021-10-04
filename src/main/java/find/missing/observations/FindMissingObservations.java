package find.missing.observations;

/**
 * @author hum
 */
public class FindMissingObservations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (n + m) * mean;
        int tmp = 0;
        for (int roll : rolls) {
            tmp += roll;
        }
        tmp = sum - tmp;
        if (tmp < n || tmp > 6 * n) {
            return new int[]{};
        }
        int[] res = new int[n];
        int t = tmp / n;
        int o = tmp % n;
        for (int i = 0; i < n; i++) {
            res[i] = t;
        }
        for (int i = 0; i < o; i++) {
            res[i] += 1;
        }
        return res;
    }
}
