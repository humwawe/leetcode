package three.equal.parts;

import java.util.Arrays;

/**
 * @author hum
 */
public class ThreeEqualParts {
    public int[] threeEqualParts(int[] a) {
        int len = a.length;
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum == 0) {
            return new int[]{0, len - 1};
        }
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        int t = sum / 3;
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int tmp = 0;

        for (int i = 0; i < len; i++) {
            if (a[i] == 1) {
                tmp += 1;
                if (tmp == 1) {
                    i1 = i;
                }
                if (tmp == t) {
                    j1 = i;
                }
                if (tmp == t + 1) {
                    i2 = i;
                }
                if (tmp == 2 * t) {
                    j2 = i;
                }
                if (tmp == 2 * t + 1) {
                    i3 = i;
                }
                if (tmp == 3 * t) {
                    j3 = i;
                }
            }
        }
        int[] part1 = Arrays.copyOfRange(a, i1, j1 + 1);
        int[] part2 = Arrays.copyOfRange(a, i2, j2 + 1);
        int[] part3 = Arrays.copyOfRange(a, i3, j3 + 1);
        if (!Arrays.equals(part1, part2) || (!Arrays.equals(part1, part3))) {
            return new int[]{-1, -1};
        }
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = a.length - j3 - 1;
        if (x < z || y < z) {
            return new int[]{-1, -1};
        }
        return new int[]{j1 + z, j2 + z + 1};
    }

}
