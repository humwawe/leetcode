package delete.columns.to.make.sorted;

/**
 * @author hum
 */
public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] a) {
        int result = 0;
        int row = a.length;
        int col = a[0].length();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row - 1; j++) {
                if (a[j].charAt(i) > a[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
