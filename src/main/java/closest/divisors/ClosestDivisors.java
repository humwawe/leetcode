package closest.divisors;

/**
 * @author hum
 */
public class ClosestDivisors {
    public int[] closestDivisors(int num) {
        int[] result = new int[2];
        int sqrt = (int) Math.sqrt(num + 2);
        for (int i = sqrt; i >= 1; i--) {
            if ((num + 1) % i == 0) {
                result[0] = i;
                result[1] = (num + 1) / i;
                return result;
            }
            if ((num + 2) % i == 0) {
                result[0] = i;
                result[1] = (num + 2) / i;
                return result;
            }
        }
        return result;
    }
}
