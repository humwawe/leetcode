package remove.sub.folders.from.the.filesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hum
 */
public class RemoveSubFoldersFromTheFilesystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        String last = folder[0];
        for (int i = 1; i < folder.length; i++) {
            if (folder[i].startsWith(last + "/")) {
                continue;
            }
            result.add(folder[i]);
            last = folder[i];
        }
        return result;
    }
}
