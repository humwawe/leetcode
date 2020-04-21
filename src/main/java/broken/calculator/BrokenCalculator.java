package broken.calculator;

/**
 * @author hum
 */
public class BrokenCalculator {
    public int brokenCalc(int x, int y) {
        if (y <= x) {
            return x - y;
        }
        int res = 0;
        while (y / 2 > x) {
            if (y % 2 == 1) {
                y += 1;
                res += 1;
            }
            y /= 2;
            res += 1;
        }

        return Math.min(x * 2 - y, x - y / 2) + res + 1;
    }
}
