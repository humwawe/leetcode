package pascal.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows == 0) {
            return results;
        }
        if (numRows == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(1);
            results.add(result);
            return results;
        }
        results = generate(numRows - 1);
        List<Integer> result = new ArrayList<>();
        result.add(1);
        List<Integer> lastResult = results.get(results.size() - 1);
        for (int i = 0; i < lastResult.size() - 1; i++) {
            result.add(lastResult.get(i) + lastResult.get(i + 1));
        }
        result.add(1);
        results.add(result);
        return results;

    }
}
