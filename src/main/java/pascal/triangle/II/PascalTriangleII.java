package pascal.triangle.II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        List<Integer> preResult = getRow(rowIndex - 1);
        result.add(1);
        for (int i = 0; i < preResult.size() - 1; i++) {
            result.add(preResult.get(i) + preResult.get(i + 1));
        }
        result.add(1);
        return result;
    }
}
