package sum.game;

/**
 * @author hum
 */
public class SumGame {
    public boolean sumGame(String num) {
        int len = num.length();
        int a = 0, b = 0;
        int tot1 = 0, tot2 = 0;
        for (int i = 0; i < len / 2; i++) {
            if (num.charAt(i) == '?') {
                a++;
            } else {
                tot1 += num.charAt(i) - '0';
            }
        }
        for (int i = len / 2; i < len; i++) {
            if (num.charAt(i) == '?') {
                b++;
            } else {
                tot2 += num.charAt(i) - '0';
            }
        }

        int tot = Math.abs(tot1 - tot2);
        int d = Math.abs(a - b);
        if (d % 2 != 0) {
            return true;
        }
        return d / 2 * 9 != tot;
    }
}
