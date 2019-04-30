package longest.common.prefix;

/**
 * @author hum
 */
public class LongestCommonPrefix {
    public  String longestCommonPrefix(String[] strs) {
//        int index = 0, min = Integer.MAX_VALUE;
//        for (int i = 0; i < strs.length; i++) {
//            if (min > strs[i].length()) {
//                min = strs[i].length();
//            }
//        }
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length < 1) {
            return "";
        }
        int index = 0;
        boolean flag = true;
        try {
            while (flag) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[0].charAt(index) != strs[i].charAt(index)) {
                        flag = false;
                        break;
                    }
                }
                index++;
            }
        } catch (IndexOutOfBoundsException e) {
            index++;
        }

        return strs[0].substring(0, index - 1);
    }


}
