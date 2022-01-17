package divide.a.string.into.groups.of.size.k;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                if (i + j >= s.length()) {
                    sb.append(fill);
                } else {
                    sb.append(s.charAt(i + j));
                }
            }
            res.add(sb.toString());
        }
        return res.toArray(new String[0]);
    }
}
