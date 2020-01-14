package reach.a.number;


/**
 * @author hum
 */
public class ReachANumber {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int step = 1;
        while (sum < target) {
            sum += step;
            step++;
        }
        if (sum == target) {
            return step;
        }
        if ((sum - target) % 2 == 0) {
            return step;
        } else if (step % 2 == 0) {
            return step + 1;
        } else {
            return step + 2;
        }
    }
}
