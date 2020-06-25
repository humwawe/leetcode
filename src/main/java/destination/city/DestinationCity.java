package destination.city;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author hum
 */
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
            set2.add(path.get(1));
        }
        for (String s : set2) {
            if (!set.contains(s)) {
                return s;
            }
        }
        return "";
    }
}
