package elimination.game;

/**
 * @author hum
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        return f(n);
    }

    private int f(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * b(n / 2);
        }
    }

    private int b(int n) {
        if (n == 1) {
            return 1;
        } else {
            if (n % 2 == 0) {
                return 2 * f(n / 2) - 1;
            } else {
                return 2 * f(n / 2);
            }
        }
    }
}
