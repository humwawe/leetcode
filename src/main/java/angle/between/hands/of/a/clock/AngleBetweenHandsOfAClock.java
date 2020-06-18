package angle.between.hands.of.a.clock;

/**
 * @author hum
 */
public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double a = hour % 12 * 30 + (double) minutes / 2;
        double b = minutes * 6;
        double t = Math.abs(a - b);
        return Math.min(t, 360 - t);
    }
}
