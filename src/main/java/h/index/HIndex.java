package h.index;

/**
 * @author hum
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] buck = new int[len + 1];
        for (int citation : citations) {
            if (citation >= len) {
                buck[len]++;
            } else {
                buck[citation]++;
            }
        }

        int s = 0;
        for (int i = len; i > 0; i--) {
            s += buck[i];
            if (s >= i) {
                return i;
            }
        }
        return 0;
    }
}
