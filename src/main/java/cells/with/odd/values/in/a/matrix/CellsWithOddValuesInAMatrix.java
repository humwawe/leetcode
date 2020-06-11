package cells.with.odd.values.in.a.matrix;

/**
 * @author hum
 */
public class CellsWithOddValuesInAMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        for (int[] index : indices) {
            row[index[0]]++;
            col[index[1]]++;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result += (row[i] + col[j]) % 2;
            }
        }
        return result;
    }
}
