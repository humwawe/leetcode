package find.positive.integer.solution.fo.a.given.equation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class FindPositiveIntegerSolutionForAGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= z; j++) {
                if (customfunction.f(i, j) == z) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }

}
