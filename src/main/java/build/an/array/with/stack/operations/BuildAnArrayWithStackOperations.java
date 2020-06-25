package build.an.array.with.stack.operations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class BuildAnArrayWithStackOperations {
    public List<String> buildArray(int[] target, int n) {
        int max = target[target.length - 1];
        Set<Integer> set = new HashSet<>();
        for (int i : target) {
            set.add(i);
        }
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (set.contains(i)) {
                result.add("Push");
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}
