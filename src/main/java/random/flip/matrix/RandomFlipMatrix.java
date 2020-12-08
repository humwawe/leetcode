package random.flip.matrix;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author hum
 */
public class RandomFlipMatrix {
    private Set<Long> set = new HashSet<>();
    private int nRows;
    private int ncols;

    public RandomFlipMatrix(int nRows, int nCols) {
        this.nRows = nRows;
        this.ncols = nCols;
    }

    public int[] flip() {
        while (true) {
            int x = new Random().nextInt(nRows);
            int y = new Random().nextInt(ncols);
            long tmp = x * 10000 + y;
            if (!set.contains(tmp)) {
                set.add(tmp);
                return new int[]{x, y};
            }
        }

    }

    public void reset() {
        set.clear();
    }
}
