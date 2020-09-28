package rearrange.spaces.between.words;

/**
 * @author hum
 */
public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        String[] s = text.trim().split("\\s+");
        int l = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                l++;
            }
        }
        StringBuilder res = new StringBuilder();
        int cnt = s.length;
        if (cnt == 1) {
            res.append(s[0]);
            for (int i = 0; i < l; i++) {
                res.append(" ");
            }
            return res.toString();
        }
        int space = l / (cnt - 1);
        int last = l % (cnt - 1);
        for (int i = 0; i < s.length - 1; i++) {
            res.append(s[i]);
            for (int j = 0; j < space; j++) {
                res.append(" ");
            }
        }
        res.append(s[cnt - 1]);
        for (int i = 0; i < last; i++) {
            res.append(" ");
        }
        return res.toString();
    }
}
