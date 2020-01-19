package reorganize.string;

/**
 * @author hum
 */
public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] tmp = new int[26];
        for (char c : s.toCharArray()) {
            tmp[c - 'a']++;
        }
        int index = getMax(tmp);
        int maxLen = tmp[index];
        if (maxLen > (s.length() + 1) / 2) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tmp[index]; i++) {
            res.append((char) ('a' + index));
        }
        tmp[index] = 0;

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (tmp[i] != 0) {
                for (int j = 0; j < tmp[i]; j++) {
                    stringBuilder.append((char) ('a' + i));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int step = (stringBuilder.length() - 1) / maxLen + 1;
        for (int i = 0; i < maxLen; i++) {
            result.append(res.charAt(i));
            for (int j = 0; j < step; j++) {
                if (i + j * maxLen < stringBuilder.length()) {
                    result.append(stringBuilder.charAt(i + j * maxLen));
                }
            }
        }
        return result.toString();
    }

    private int getMax(int[] tmp) {
        int max = 0;
        int res = -1;
        for (int i = 0; i < 26; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
                res = i;
            }
        }
        return res;
    }
}
