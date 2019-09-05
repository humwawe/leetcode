package valid.perfect.square;

/**
 * @author hum
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long i = 1;
        while (i * i < num) {
            i++;
        }
        return i * i == num;
    }
}
