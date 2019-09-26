package binary.watch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class BinaryWatch {
    List<String> result = new ArrayList<>();
    List<Integer> h = new ArrayList<>();
    List<Integer> m = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        int[] a = new int[]{1, 2, 4, 8};
        int[] b = new int[]{1, 2, 4, 8, 16, 32};
        helper(num, a, b);
        return result;
    }

    private void helper(int num, int[] a, int[] b) {
        for (int i = 0; i <= Math.min(num, 4); i++) {
            h.clear();
            if (i == 0) {
                h.add(0);
            }
            getH(a, i, 0, 0);
            m.clear();
            if (num - i == 0) {
                m.add(0);
            }
            getM(b, num - i, 0, 0);
            for (Integer integer : h) {
                if (integer <= 11) {
                    for (Integer integer1 : m) {
                        if (integer1 <= 59) {
                            result.add(integer + ":" + (integer1 < 10 ? "0" + integer1 : integer1));
                        }
                    }
                }
            }


        }
    }

    private void getM(int[] a, int count, int start, int sum) {
        if (count == 0 && sum != 0) {
            m.add(sum);
        }
        if (start == a.length || count <= 0) {
            return;
        }
        getM(a, count - 1, start + 1, sum + a[start]);
        getM(a, count, start + 1, sum);
    }

    private void getH(int[] a, int count, int start, int sum) {
        if (count == 0 && sum != 0) {
            h.add(sum);
        }
        if (start == a.length || count <= 0) {
            return;
        }
        getH(a, count - 1, start + 1, sum + a[start]);
        getH(a, count, start + 1, sum);
    }
}
