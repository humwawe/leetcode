package ambiguous.coordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class AmbiguousCoordinates {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; ++i) {
            for (String left : helper(s, 1, i)) {
                for (String right : helper(s, i, s.length() - 1)) {
                    result.add("(" + left + ", " + right + ")");
                }
            }
        }
        return result;
    }

    private List<String> helper(String s, int i, int j) {
        List<String> res = new ArrayList<>();
        for (int d = 1; d <= j - i; ++d) {
            String left = s.substring(i, i + d);
            String right = s.substring(i + d, j);
            if ((left.startsWith("0") && !left.equals("0")) || right.endsWith("0")) {
                continue;
            }
            res.add(left + (d < j - i ? "." : "") + right);
        }
        return res;
    }

}
