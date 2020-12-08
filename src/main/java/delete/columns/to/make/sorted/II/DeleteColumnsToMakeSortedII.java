package delete.columns.to.make.sorted.II;

/**
 * @author hum
 */
public class DeleteColumnsToMakeSortedII {
    public int minDeletionSize(String[] a) {
        int col = a[0].length();
        int row = a.length;
        int result = 0;
        boolean[] vis = new boolean[row];
        for (int i = 0; i < col; i++) {
            boolean f = false;
            for (int j = 0; j < row - 1; j++) {
                char c1 = a[j].charAt(i);
                char c2 = a[j + 1].charAt(i);
                if (vis[j]) {
                    continue;
                }
                if (c1 > c2) {
                    result++;
                    f = true;
                    break;
                }
            }
            if (!f) {
                for (int j = 0; j < row - 1; j++) {
                    char c1 = a[j].charAt(i);
                    char c2 = a[j + 1].charAt(i);
                    if (c1 < c2) {
                        vis[j] = true;
                    }
                }
            }
        }
        return result;
    }
}
