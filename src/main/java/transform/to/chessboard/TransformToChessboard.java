package transform.to.chessboard;

import java.util.*;

public class TransformToChessboard {
    public int movesToChessboard(int[][] board) {
        int len = board.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] row : board) {
            int code = 0;
            for (int x : row) {
                code = 2 * code + x;
            }
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        int k1 = analyzeCount(map, len);
        if (k1 == -1) {
            return -1;
        }
        map.clear();
        for (int c = 0; c < len; ++c) {
            int code = 0;
            for (int[] ints : board) {
                code = 2 * code + ints[c];
            }
            map.put(code, map.getOrDefault(code, 0) + 1);
        }

        int k2 = analyzeCount(map, len);
        return k2 >= 0 ? k1 + k2 : -1;
    }

    private int analyzeCount(Map<Integer, Integer> count, int len) {
        if (count.size() != 2) {
            return -1;
        }
        Iterator<Integer> iterator = count.keySet().iterator();
        int k1 = iterator.next();
        int k2 = iterator.next();
        if (!(count.get(k1) == len / 2 && count.get(k2) == (len + 1) / 2) && !(count.get(k2) == len / 2 && count.get(k1) == (len + 1) / 2)) {
            return -1;
        }
        if ((k1 ^ k2) != (1 << len) - 1) {
            return -1;
        }

        int allOne = (1 << len) - 1;
        int ones = Integer.bitCount(k1 & allOne);
        int cand = Integer.MAX_VALUE;
        if (len % 2 == 0 || ones * 2 < len) {
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0xAAAAAAAA & allOne) / 2);
        }
        if (len % 2 == 0 || ones * 2 > len) {
            cand = Math.min(cand, Integer.bitCount(k1 ^ 0x55555555 & allOne) / 2);
        }

        return cand;
    }
}
