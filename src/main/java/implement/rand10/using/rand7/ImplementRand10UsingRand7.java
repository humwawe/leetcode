package implement.rand10.using.rand7;

import java.util.Random;

/**
 * @author hum
 */
public class ImplementRand10UsingRand7 {
    public int rand10() {

        while (true) {
            int t = rand7();
            if (t == 7) {
                continue;
            }
            boolean flag = t % 2 == 0;
            if (flag) {
                int tmp = 7 + rand7();
                if (tmp <= 10) {
                    return tmp;
                }
            } else {
                return rand7();
            }
        }
    }

    private int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
