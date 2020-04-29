package smallest.integer.divisible.by.k;

/**
 * @author hum
 */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        boolean[] vis = new boolean[k + 1];
        int num = 1;
        int result = 1;
        while (!vis[num]) {
            int t = num % k;
            if (t == 0) {
                return result;
            }
            vis[t] = true;
            num = (t * 10 + 1) % k;
            result++;
        }
        return -1;
    }
}
