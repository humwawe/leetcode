package range.addition.II;

public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for (int[] op : ops) {
            x = Math.min(x, op[0]);
            y = Math.min(y, op[1]);
        }
        return x * y;
    }
}
