package race.car;

/**
 * @author hum
 */
public class RaceCar {
    int[] memo;

    public int racecar(int target) {
        memo = new int[target + 1];
        return helper(target);
    }

    private int helper(int target) {
        if (memo[target] > 0) {
            return memo[target];
        }
        int n = (int) Math.ceil(Math.log(target + 1) / Math.log(2));
        System.out.println(n);
        if (1 << n == target + 1) {
            return memo[target] = n;
        }
        int tmp = n + 1 + helper(((1 << n) - 1) - target);
        for (int i = 0; i < n - 1; i++) {
            int cur = (1 << (n - 1)) - (1 << i);
            tmp = Math.min(tmp, n + i + 1 + helper(target - cur));
        }
        return memo[target] = tmp;
    }

}
