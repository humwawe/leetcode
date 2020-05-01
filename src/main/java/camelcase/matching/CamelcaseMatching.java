package camelcase.matching;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        f:
        for (String query : queries) {
            int i = 0;
            int j = 0;
            while (i < query.length() && j < pattern.length()) {
                char c1 = query.charAt(i);
                char c2 = pattern.charAt(j);
                if (c1 == c2) {
                    i++;
                    j++;
                } else {
                    if (Character.isUpperCase(c2) && Character.isLowerCase(c1)) {
                        i++;
                    } else if (Character.isLowerCase(c1) && Character.isLowerCase(c2)) {
                        i++;
                    } else if (Character.isUpperCase(c1)) {
                        result.add(false);
                        continue f;
                    }
                }
            }
            if (i == query.length() && j == pattern.length()) {
                result.add(true);
            } else if (j == pattern.length()) {
                while (i < query.length()) {
                    if (Character.isUpperCase(query.charAt(i))) {
                        result.add(false);
                        break;
                    }
                    i++;
                }
                if (i == query.length()) {
                    result.add(true);
                }
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
