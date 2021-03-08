package check.number.is.a.sum.of.powers.of.three;

/**
 * @author hum
 */
public class CheckIfNumberIsASumOfPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            int t = n % 3;
            if (t == 2) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
