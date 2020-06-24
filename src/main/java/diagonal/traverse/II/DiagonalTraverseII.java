package diagonal.traverse.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> list = nums.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (!map.containsKey(i + j)) {
                    map.put(i + j, new ArrayList<>());
                }
                map.get(i + j).add(0, list.get(j));
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1e5 + 5; i++) {
            if (!map.containsKey(i)) {
                break;
            }
            List<Integer> list = map.get(i);
            res.addAll(list);
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
