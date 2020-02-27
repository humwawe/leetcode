package mirror.reflection;

/**
 * @author hum
 */
public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int[] point = new int[]{0, 0};
        int dirX = 1;
        int dirY = 1;
        int[][] end = new int[][]{{p, 0}, {p, p}, {0, p}};
        while (true) {
            point[0] += dirX * p;
            dirX *= -1;
            point[1] += dirY * q;
            if (point[1] > p) {
                point[1] = p - point[1] % p;
                dirY *= -1;
            }
            if (point[1] < 0) {
                point[1] = -point[1];
                dirY *= -1;
            }
            for (int i = 0; i < end.length; i++) {
                int[] ints = end[i];
                if (point[0] == ints[0] && point[1] == ints[1]) {
                    return i;
                }
            }
        }
    }
}
