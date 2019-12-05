package find.duplicate.file.in.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hum
 */
public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] dir = path.split(" ");
            String pre = dir[0];
            for (int i = 1; i < dir.length; i++) {
                int index = dir[i].indexOf("(");
                String key = dir[i].substring(index);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(pre + "/" + dir[i].substring(0, index));
            }
        }
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                result.add(list);
            }

        }
        return result;
    }
}
