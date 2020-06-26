package subrectangle.queries;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class SubrectangleQueries {
    List<int[]> list = new ArrayList<>();
    int[][] r;

    public SubrectangleQueries(int[][] rectangle) {
        this.r = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        list.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int i = list.size() - 1; i >= 0; i--) {
            int[] rcs = list.get(i);
            if (rcs[0] <= row && rcs[1] <= col && rcs[2] >= row && rcs[3] >= col) {
                return rcs[4];
            }
        }
        return r[row][col];
    }
}
