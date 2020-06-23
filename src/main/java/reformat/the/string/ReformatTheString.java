package reformat.the.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class ReformatTheString {
    public String reformat(String s) {
        int len = s.length();
        List<Character> cs = new ArrayList<>();
        List<Character> ns = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                ns.add(c);
            } else {
                cs.add(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (cs.size() == 0 || ns.size() == 0) {
            return s;
        }
        if (Math.abs(cs.size() - ns.size()) > 1) {
            return "";
        }
        int n = Math.min(cs.size(), ns.size());
        for (int i = 0; i < n; i++) {
            stringBuilder.append(ns.get(i));
            stringBuilder.append(cs.get(i));
        }
        if (cs.size() == ns.size()) {
            return stringBuilder.toString();
        } else if (cs.size() > ns.size()) {
            stringBuilder.insert(0, cs.get(cs.size() - 1));
        } else {
            stringBuilder.append(ns.get(ns.size() - 1));
        }
        return stringBuilder.toString();
    }
}
