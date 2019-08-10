package power.of.three;

/**
 * @author hum
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        String str = Integer.toString(n, 3);
        return str.lastIndexOf("1") == 0 && !str.contains("2");
    }
}
