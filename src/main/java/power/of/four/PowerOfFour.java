package power.of.four;

/**
 * @author hum
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        String str = Integer.toString(num, 4);
        return str.lastIndexOf("1") == 0 && !str.contains("2") && !str.contains("3");
    }
}
