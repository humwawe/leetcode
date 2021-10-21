package remove.colored.pieces.both.neighbors.are.the.same.color;

/**
 * @author hum
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public boolean winnerOfGame(String colors) {
        int cnt1 = 0;
        int cnt2 = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for (char c : colors.toCharArray()) {
            if (c == 'A') {
                tmp1++;
                tmp2 = 0;
                if (tmp1 >= 3) {
                    cnt1++;
                }
            } else {
                tmp1 = 0;
                tmp2++;
                if (tmp2 >= 3) {
                    cnt2++;
                }
            }
        }
        return cnt1 > cnt2;
    }

}
