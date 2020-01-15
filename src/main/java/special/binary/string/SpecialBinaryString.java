package special.binary.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hum
 */
public class SpecialBinaryString {
    public String makeLargestSpecial(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int start = 0;
        int countOne = 0;
        for (int i = 0; i < s.length(); ++i) {
            countOne += s.charAt(i) == '1' ? 1 : -1;
            if (countOne == 0) {
                String str = s.substring(start + 1, i);
                list.add("1" + makeLargestSpecial(str) + "0");
                start = i + 1;
            }
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; --i) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

}
