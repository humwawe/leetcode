package find.the.winner.of.the.circular.game;

/**
 * @author hum
 */
public class FindTheWinnerOfTheCircularGame {
    public int findTheWinner(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }
}
