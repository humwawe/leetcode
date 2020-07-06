package last.moment.before.all.ants.fall.out.of.a.plank;

/**
 * @author hum
 */
public class LastMomentBeforeAllAntsFallOutOfAPlank {
    public int getLastMoment(int n, int[] left, int[] right) {
        int result = 0;
        for (int i : left) {
            result = Math.max(result, i);
        }
        for (int i : right) {
            result = Math.max(result, n - i);
        }
        return result;
    }
}
