package making.file.names.unique;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hum
 */
public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        int len = names.length;
        String[] result = new String[len];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                result[i] = names[i];
                map.put(names[i], 1);
                continue;
            }
            int idx = map.get(names[i]) + 1;
            while (map.containsKey(names[i] + "(" + String.valueOf(idx) + ")")) {
                idx++;
            }
            result[i] = names[i] + "(" + String.valueOf(idx) + ")";
            map.put(names[i], idx);
            map.put(result[i], 1);
        }
        return result;
    }
}
