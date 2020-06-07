package queens.that.can.attack.the.king;

import java.util.*;

/**
 * @author hum
 */
public class QueensThatCanAttackTheKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int[] queen : queens) {
            set.add(queen[0] * 10 + queen[1]);
        }
        int x = king[0];
        int y = king[1];
        int[][] fs = new int[][]{{0, 1}, {1, 0}, {1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {-1, 1}, {1, -1}};

        for (int[] f : fs) {
            int newX = x;
            int newY = y;
            while (true) {
                newX += f[0];
                newY += f[1];
                if (newX < 0 || newX >= 8 || newY < 0 || newY >= 8) {
                    break;
                } else {
                    if (set.contains(newX * 10 + newY)) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(newX);
                        tmp.add(newY);
                        result.add(tmp);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
