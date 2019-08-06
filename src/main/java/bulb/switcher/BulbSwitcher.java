package bulb.switcher;

/**
 * @author hum
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
//        int result = 0;
//        for (int i = 1; i <= n; i++) {
//            if (helper(i) % 2 == 0) {
//                result++;
//            }
//        }
//        return result;
    }

    private int helper(int num) {
        int ctr = 0;
        for (int i = 1; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0 && i * i != num) {
                ctr += 2;
            } else if (i * i == num) {
                ctr++;
            }
        }
        return ctr;
    }


}
