package n.repeated.element.in.size.two.n.array;

/**
 * @author hum
 */
public class NRepeatedElementInSize2NArray {
    public int repeatedNTimes(int[] a) {
        boolean[] f = new boolean[10005];
        for (int i : a) {
            if (f[i]) {
                return i;
            } else {
                f[i] = true;
            }
        }
        return -1;
    }
}
