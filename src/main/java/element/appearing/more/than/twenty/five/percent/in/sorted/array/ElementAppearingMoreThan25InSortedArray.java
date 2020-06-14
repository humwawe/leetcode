package element.appearing.more.than.twenty.five.percent.in.sorted.array;

/**
 * @author hum
 */
public class ElementAppearingMoreThan25InSortedArray {
    public int findSpecialInteger(int[] arr) {
        int[] t = new int[500005];
        int len = arr.length;
        for (int i : arr) {
            t[i]++;
            if (t[i] >= len / 4 + 1) {
                return i;
            }
        }
        return -1;
    }
}
