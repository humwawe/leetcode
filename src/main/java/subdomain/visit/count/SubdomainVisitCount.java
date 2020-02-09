package subdomain.visit.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.valueOf(split[0]);
            map.put(split[1], map.getOrDefault(split[1], 0) + count);
            for (int i = split[1].length() - 1; i >= 0; i--) {
                if (split[1].charAt(i) == '.') {
                    String tmp = split[1].substring(i + 1);
                    map.put(tmp, map.getOrDefault(tmp, 0) + count);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String s : map.keySet()) {
            result.add(map.get(s) + " " + s);
        }
        return result;
    }
}
