package compare.version.numbers;

/**
 * @author hum
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");
        int i;
        for (i = 0; i < vers1.length && i < vers2.length; i++) {
            String tmp1 = helper(vers1[i]);
            String tmp2 = helper(vers2[i]);
            if ("".equals(tmp1) && "".equals(tmp2)) {
                continue;
            } else if (!"".equals(tmp1) && "".equals(tmp2)) {
                return 1;
            } else if ("".equals(tmp1) && !"".equals(tmp2)) {
                return -1;
            }
            if (Integer.valueOf(tmp1) > Integer.valueOf(tmp2)) {
                return 1;
            } else if (Integer.valueOf(tmp1) < Integer.valueOf(tmp2)) {
                return -1;
            }
        }
        while (i < vers1.length) {
            if (!"".equals(helper(vers1[i]))) {
                return 1;
            }
            i++;
        }
        while (i < vers2.length) {
            if (!"".equals(helper(vers2[i]))) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    private String helper(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == '0') {
            start++;
        }

        return s.substring(start, end + 1);
    }
}
