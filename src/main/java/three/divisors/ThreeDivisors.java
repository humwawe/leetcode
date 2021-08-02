package three.divisors;

/**
 * @author hum
 */
public class ThreeDivisors {
    public boolean isThree(int n) {
        int cnt = 2;
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) {
                cnt++;
            }
        }
        return cnt == 3;
    }
}
