package throne.inheritance;

import java.util.*;

/**
 * @author hum
 */
public class ThroneInheritance {
    String k;
    Set<String> d;
    Map<String, List<String>> map;

    public ThroneInheritance(String kingName) {
        k = kingName;
        d = new HashSet<>();
        map = new HashMap<>();
        map.put(k, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        map.get(parentName).add(childName);
        map.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        d.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        helper(res, k);
        return res;
    }

    private void helper(List<String> res, String k) {
        if (!d.contains(k)) {
            res.add(k);
        }
        List<String> strings = map.get(k);
        for (String string : strings) {
            helper(res, string);
        }
    }
}
