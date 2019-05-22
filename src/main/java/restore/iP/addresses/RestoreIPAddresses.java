package restore.iP.addresses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hum
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        helper(0, s, result, new StringBuilder());
        return result;
    }

    private void helper(int i, String s, List<String> result, StringBuilder path) {
        if (i == 4 && s.isEmpty()) {
            result.add(path.substring(0, path.length() - 1));
            return;
        }
        if (i == 4 || s.isEmpty()) {
            return;
        }

        for (int j = 1; j <= 3 && j <= s.length(); j++) {
            String tmp = s.substring(0, j);
            if (Integer.valueOf(tmp) <= 255 && !(!tmp.equals("0") && tmp.startsWith("0"))) {
                path.append(tmp).append(".");
                helper(i + 1, s.substring(j), result, path);
                path.delete(path.length() - tmp.length() - 1, path.length());
            }
        }
    }

}
