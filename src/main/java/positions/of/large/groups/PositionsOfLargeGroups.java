package positions.of.large.groups;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        int count = 0;
        List<List<Integer>> result = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i < s.length(); ) {
            while (i < s.length() && s.charAt(i) == s.charAt(prev)) {
                i++;
                count++;
            }
            if (count >= 3) {
                List<Integer> list = new ArrayList<>();
                list.add(prev);
                list.add(i - 1);
                result.add(list);
            }
            prev = i;
            count = 0;
        }
        return result;
    }
}
