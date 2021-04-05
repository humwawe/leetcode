package evaluate.the.bracket.pairs.of.a.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class EvaluateTheBracketPairsOfAString {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                int j = i + 1;
                StringBuilder key = new StringBuilder();
                while (j < s.length() && s.charAt(j) != ')') {
                    key.append(s.charAt(j++));
                }
                String value = map.get(key.toString()) == null ? "?" : map.get(key.toString());
                res.append(value);
                i = j + 1;
            } else {
                res.append(s.charAt(i));
                i++;
            }
        }
        return res.toString();
    }
}
