package rings.and.rods;

/**
 * @author hum
 */
public class RingsAndRods {
    public int countPoints(String rings) {
        int len = rings.length();
        int[] a = new int[10];
        for (int i = 0; i < len; i += 2) {
            char c = rings.charAt(i);
            int tmp = 0;
            if (c == 'R') {
                tmp = 1;
            } else if (c == 'G') {
                tmp = 1 << 1;
            } else {
                tmp = 1 << 2;
            }
            int num = rings.charAt(i + 1) - '0';

            a[num] |= tmp;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (a[i] == 7) {
                res++;
            }
        }
        return res;
    }
}
