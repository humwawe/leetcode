package number.of.laser.beams.in.a.bank;

/**
 * @author hum
 */
public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int last = 0;
        int res = 0;
        for (String s : bank) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    cnt++;
                }
            }
            if (cnt != 0) {
                res += cnt * last;
                last = cnt;
            }
        }
        return res;
    }
}
