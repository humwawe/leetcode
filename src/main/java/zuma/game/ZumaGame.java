package zuma.game;

/**
 * @author hum
 */
public class ZumaGame {
    int result = 10;

    public int findMinStep(String board, String hand) {
        if (!check(board, hand)) {
            return -1;
        }
        StringBuilder b = new StringBuilder(board);
        StringBuilder h = new StringBuilder(hand);
        helper(b, h, 0);
        return result == 10 ? -1 : result;
    }

    private boolean check(String board, String hand) {
        int[] res = new int[26];
        for (int i = 0; i < board.length(); i++) {
            res[board.charAt(i) - 'A']++;
        }
        for (int i = 0; i < hand.length(); i++) {
            res[hand.charAt(i) - 'A']++;
        }
        for (int i = 0; i < board.length(); i++) {
            int j = board.charAt(i) - 'A';
            if (res[j] == 1 || res[j] == 2) {
                return false;
            }
        }
        return true;
    }

    private void helper(StringBuilder board, StringBuilder hand, int step) {
        if (step >= result) {
            return;
        }
        if (board.length() == 0) {
            result = Math.min(result, step);
        }
        if (hand.length() == 0 && board.length() != 1) {
            return;
        }

        int lenB = board.length();
        int lenH = hand.length();
        for (int i = 0; i <= lenB; i++) {
            for (int j = 0; j < lenH; j++) {
                char cj = hand.charAt(j);
                if (i != lenB && board.charAt(i) != cj) {
                    continue;
                }
                board.insert(i, cj);
                String tmp = remove(board.toString());
                hand.deleteCharAt(j);
                helper(new StringBuilder(tmp), hand, step + 1);
                hand.insert(j, cj);
                board.deleteCharAt(i);
            }
        }
    }

    private String remove(String board) {
        String[] colors = {"RRR", "BBB", "YYY", "WWW", "GGG"};
        String res = board;
        for (String color : colors) {
            int i = board.indexOf(color);
            if (i != -1) {
                char tmp = board.charAt(i);
                int j = i;
                while (j < board.length() && board.charAt(j) == tmp) {
                    j++;
                }
                if (j == board.length()) {
                    res = board.substring(0, i);
                } else {
                    res = board.substring(0, i) + board.substring(j);
                }
                return remove(res);
            }
        }
        return res;
    }

}
